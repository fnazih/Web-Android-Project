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
    private lateinit var eventImageView: ImageView
    private lateinit var eventTitleView: TextView
    private lateinit var eventLeadTextView: TextView
    private lateinit var eventDescriptionView: TextView
    private lateinit var eventDateStartView: TextView
    private lateinit var eventDateEndView: TextView
    private lateinit var addressNameView: TextView
    private lateinit var addressStreetView: TextView
    private lateinit var addressZipCodeView: TextView
    private lateinit var addressCityView: TextView
    private lateinit var transportIndicationsView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        eventImageView = findViewById(R.id.eventImageView)
        eventTitleView = findViewById(R.id.eventTitleView)
        eventLeadTextView = findViewById(R.id.eventLeadTextView)
        eventDescriptionView = findViewById(R.id.eventDescriptionView)
        eventDateStartView = findViewById(R.id.dateStartView)
        addressNameView = findViewById(R.id.addressNameView)
        addressStreetView = findViewById(R.id.addressStreetView)
        addressZipCodeView = findViewById(R.id.addressZipCodeView)
        addressCityView = findViewById(R.id.addressCityView)

        init_page()
    }

    fun init_page() {
        //Picasso.get().load(intent.getStringExtra("img_url")).into(eventImageView)
        eventTitleView.text = intent.getStringExtra("title")
        eventDateStartView.text = intent.getStringExtra("date_start")
        eventDateEndView.text = intent.getStringExtra("date_end")
        eventLeadTextView.text = intent.getStringExtra("leadText")
        eventDescriptionView.text = intent.getStringExtra("description")
        addressNameView.text = intent.getStringExtra("addressName")
        addressStreetView.text = intent.getStringExtra("addressStreet")
        addressZipCodeView.text = intent.getStringExtra("addressZipCode")
        addressCityView.text = intent.getStringExtra("addressCity")
        transportIndicationsView.text = intent.getStringExtra("transport_indic")
    }
}