/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SubCategoryActivity : AppCompatActivity() {
    private lateinit var subCategoryName: TextView
    private var events: ArrayList<Event> = arrayListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        this.subCategoryName = findViewById(R.id.subCategoryTitleViewId)
        this.subCategoryName.text = intent.getStringExtra(Intent.EXTRA_TEXT)

        updateDivider()

        this.recyclerView = findViewById(R.id.recyclerView)
        eventAdapter = EventAdapter(events)
        this.recyclerView.adapter = eventAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        this.recyclerView.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(this, linearLayoutManager.orientation)
        this.recyclerView.addItemDecoration(dividerItemDecoration)

        (recyclerView.adapter as EventAdapter)?.refreshData(events)
        recyclerView.adapter?.notifyDataSetChanged()
    }

    fun updateDivider() {
        var event1: Event = Event("1",
            "Event1",
            "img_url",
            "Category",
            "Lead text blabla",
            "Programs",
            "Description blablablabla description blabla",
            "date start",
            "date end",
        "Contact name",
        "Phone",
        "mail",
        "address name",
        "street",
        "zipcode",
        "city",
        "transport indic.",
        "cover_alt",
        "price type",
        "detail",
        "access_link",
        "tags")

        var event2: Event = Event("2",
            "Event2",
            "img_url",
            "Category",
            "Lead text blabla",
            "Programs",
            "Description blablablabla description blabla",
            "date start",
            "date end",
            "Contact name",
            "Phone",
            "mail",
            "address name",
            "street",
            "zipcode",
            "city",
            "transport indic.",
            "cover_alt",
            "price type",
            "detail",
            "access_link",
            "tags")

        events.add(event1)
        events.add(event2)
    }

}