package com.ismin.projectapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var eventIcon = itemView.findViewById<ImageView>(R.id.eventImageView)
    var eventTitle = itemView.findViewById<TextView>(R.id.eventTitleView)
    var eventDescription = itemView.findViewById<TextView>(R.id.eventDescriptionView)
    var eventAddressName = itemView.findViewById<TextView>(R.id.addressNameView)
    var eventAddressCity = itemView.findViewById<TextView>(R.id.addressCity)
    var eventAddressZipCode = itemView.findViewById<TextView>(R.id.addressZipCode)

}