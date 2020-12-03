/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_EVENTS = "ARG_EVENTS"

class SubCategoryFragment : Fragment(), onEventItemClickListener {
    private var events: ArrayList<Event> = arrayListOf()
    private lateinit var recyclerViewEvents: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private lateinit var listener: MyActivityCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            events = arguments!!.getSerializable(ARG_EVENTS) as ArrayList<Event>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub_category, container, false)

        this.recyclerViewEvents = view.findViewById(R.id.recyclerView)
        eventAdapter = EventAdapter(events, this)
        this.recyclerViewEvents.adapter = eventAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        this.recyclerViewEvents.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.recyclerViewEvents.addItemDecoration(dividerItemDecoration)

        return view
    }

    override fun onItemClick(position: Int) {
        val clickedEvent: Event = events[position]
        listener.goToEvent(clickedEvent)
    }

    override fun onFavButtonClick(position: Int) {
        listener.toggleFavorite(position)
        events[position].fav = !events[position].fav
        //eventAdapter.refreshData(events)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MyActivityCallback) {
            listener = context
        } else {
            throw RuntimeException("$context must implement MyActivityCallback")
        }
    }

    override fun isFav(position: Int): Boolean{
        return events[position].fav
    }

    companion object {
        @JvmStatic
        fun newInstance(eventsToDisplay: ArrayList<Event>): SubCategoryFragment {
            val bundle = Bundle()
            bundle.putSerializable(ARG_EVENTS, eventsToDisplay)
            val eventListFragment = SubCategoryFragment()
            eventListFragment.arguments = bundle
            return eventListFragment
        }
    }
}