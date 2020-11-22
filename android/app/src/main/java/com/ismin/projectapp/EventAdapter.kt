/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val events: ArrayList<Event>): RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.event_row_layout, parent, false)
        return EventViewHolder(row)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val (title, description, address) = events[position]

        holder.eventTitle.text = title
        holder.eventDescription.text = description
        holder.eventAddressName.text = address
    }

    fun refreshData(updatedEvents: java.util.ArrayList<Event>) {
        events.clear()
        events.addAll(updatedEvents)
    }

}
