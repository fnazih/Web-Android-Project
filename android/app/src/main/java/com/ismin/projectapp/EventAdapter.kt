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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.event_row_layout, parent, false)
        return EventViewHolder(row)
    }

    override fun getItemCount(): Int {
        return this.events.size
    }

    fun refreshData(updatedEvents: ArrayList<Event>) {
        events.clear()
        System.out.println("Ca rentre dans refreshData")
        System.out.println(updatedEvents)
        for(event: Event in updatedEvents) {
            events.add(event)
            System.out.println(event)
        }
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
                    if(listener.isFav(adapterPosition)) {
                        favButton.setImageResource(R.drawable.blankstar)
                    }
                    else {
                        favButton.setImageResource(R.drawable.filledstar)
                    }
                    listener.onFavButtonClick(adapterPosition)
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

        if(listener.isFav(position)){
            holder.favButton.setImageResource(R.drawable.filledstar)
        }
        else{
            holder.favButton.setImageResource(R.drawable.blankstar)
        }
    }
}