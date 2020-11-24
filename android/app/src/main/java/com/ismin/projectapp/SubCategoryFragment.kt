package com.ismin.projectapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_EVENTS = "events"

class SubCategoryFragment : Fragment() {
    private var events: ArrayList<Event> = arrayListOf()
    private lateinit var recyclerViewEvents: RecyclerView
    private lateinit var eventAdapter: EventAdapter

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
        eventAdapter = EventAdapter(events)
        this.recyclerViewEvents.adapter = eventAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        this.recyclerViewEvents.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.recyclerViewEvents.addItemDecoration(dividerItemDecoration)

        return view
    }

    companion object {
        fun newInstance(newFragment: ArrayList<Event>) =
            SubCategoryFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_EVENTS, newFragment)
                }
            }
    }
}