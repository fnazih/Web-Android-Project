package com.ismin.projectapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_EVENT = "events"
private const val SUBCATEGORY_FRAGMENT_KEY = "SUBCATEGORY_FRAGMENT_KEY"

/**
 * A simple [Fragment] subclass.
 * Use the [SubCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubCategoryFragment : Fragment() {
    private lateinit var subCategoryName: TextView
    private var events: ArrayList<Event> = arrayListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            events = arguments!!.getSerializable(ARG_EVENT) as ArrayList<Event>
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub_category, container, false)

        this.subCategoryName = view.findViewById(R.id.subCategoryTitleViewId)
        this.subCategoryName.text = arguments!!.getString(SUBCATEGORY_FRAGMENT_KEY)

        this.recyclerView = view.findViewById(R.id.recyclerView)
        eventAdapter = EventAdapter(events)
        this.recyclerView.adapter = eventAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        this.recyclerView.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.recyclerView.addItemDecoration(dividerItemDecoration)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(newFragmentEventList: ArrayList<Event>) =
            SubCategoryFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_EVENT, newFragmentEventList)
                }
            }
    }
}