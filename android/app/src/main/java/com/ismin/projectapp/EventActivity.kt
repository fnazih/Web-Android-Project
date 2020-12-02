/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class EventActivity : AppCompatActivity() {
    private lateinit var displayedEvent: Event
    private lateinit var eventImageView: ImageView
    private lateinit var eventTitleView: TextView
    private lateinit var eventLeadTextView: TextView
    //private lateinit var eventDescriptionView: TextView
    private lateinit var eventDateStartView: TextView
    private lateinit var eventDateEndView: TextView
    private lateinit var addressNameView: TextView
    private lateinit var addressStreetView: TextView
    private lateinit var addressZipCodeView: TextView
    private lateinit var addressCityView: TextView
    //private lateinit var transportIndicationsView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        eventImageView = findViewById(R.id.eventImageView)
        eventTitleView = findViewById(R.id.eventTitleView)
        eventLeadTextView = findViewById(R.id.eventLeadTextView)
        //eventDescriptionView = findViewById(R.id.eventDescriptionView)
        eventDateStartView = findViewById(R.id.dateStartView)
        eventDateEndView = findViewById(R.id.dateEndView)
        addressNameView = findViewById(R.id.addressNameView)
        addressStreetView = findViewById(R.id.addressStreetView)
        addressZipCodeView = findViewById(R.id.addressZipCodeView)
        addressCityView = findViewById(R.id.addressCityView)
        //transportIndicationsView = findViewById(R.id.transportIndicationsView)

        displayedEvent = intent.getSerializableExtra("Event") as Event
        init_page(displayedEvent)
    }

    fun init_page(event: Event) {
        Picasso.get().load(event.cover_url).into(eventImageView)
        eventTitleView.text = event.title
        eventDateStartView.text = event.date_start
        eventDateEndView.text = event.date_end
        eventLeadTextView.text = event.lead_text
        //eventDescriptionView.text = event.description
        addressNameView.text = event.address_name
        addressStreetView.text = event.address_street
        addressZipCodeView.text = event.address_zipcode
        addressCityView.text = event.address_city
        //transportIndicationsView.text = event.transport_indications
    }
}