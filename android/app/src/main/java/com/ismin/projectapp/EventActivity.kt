package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EventActivity : AppCompatActivity() {
    private var eventTitleView: TextView= findViewById(R.id.eventTitleView)
    private var eventLeadTextView: TextView = findViewById(R.id.eventLeadTextView)
    private var eventDescriptionView: TextView = findViewById(R.id.eventDescriptionView)
    private var addressNameView: TextView = findViewById(R.id.addressNameView)
    private var addressStreetView: TextView = findViewById(R.id.addressStreetView)
    private var addressZipCodeView: TextView = findViewById(R.id.addressZipCodeView)
    private var addressCityView: TextView = findViewById(R.id.addressCityView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        //val displayedEvent = intent.getSerializableExtra("MyEvent")
        //eventDescriptionView.text = displayedEvent.toString()
    }
}