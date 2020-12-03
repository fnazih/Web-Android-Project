/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class EventAdapter(private val events: ArrayList<Event>, private val listener: onEventItemClickListener): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    private lateinit var favButt: Button

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.event_row_layout, parent, false)
        return EventViewHolder(row)
    }

    override fun getItemCount(): Int {
        return this.events.size
    }

    fun refreshData(updatedEvents: java.util.ArrayList<Event>) {
        events.clear()
        events.addAll(updatedEvents)
        notifyDataSetChanged()
    }

    inner class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var eventTitle: TextView
        var eventDate: TextView
        var eventIcon: ImageView
        var favButton: ImageButton

        init {
            itemView.setOnClickListener(this)
            this.eventTitle = itemView.findViewById(R.id.eventTitleRow)
            this.eventIcon = itemView.findViewById(R.id.eventIconView)
            this.eventDate = itemView.findViewById(R.id.eventDateListView)
            this.favButton = itemView.findViewById(R.id.addToFavButton)
            favButton.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when(v) {
                favButton -> {
                    if(favButton.background.equals(R.drawable.blankstar)) {
                        favButton.setImageResource(R.drawable.filledstar)
                        listener.onFavButtonClick(adapterPosition)
                    }
                    else {
                        favButton.setImageResource(R.drawable.blankstar)
                    }
                }
                else -> {
                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position)
                    }
                }
            }

        }
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentEvent = this.events[position]

        holder.eventTitle.text = currentEvent.title
        Picasso.get().load(currentEvent.cover_url).into(holder.eventIcon)
        holder.eventDate.text = currentEvent.date_start
    }
}