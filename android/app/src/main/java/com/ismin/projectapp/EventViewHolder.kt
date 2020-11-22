/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var eventIcon: ImageView
    var eventTitle: TextView
    var eventDate: TextView

    init {
        this.eventTitle = itemView.findViewById(R.id.eventTitleRow)
        this.eventIcon = itemView.findViewById(R.id.eventIcon)
        this.eventDate = itemView.findViewById(R.id.eventDateListView)
    }
}