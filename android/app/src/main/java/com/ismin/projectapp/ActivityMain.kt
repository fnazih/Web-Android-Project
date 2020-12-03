/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val EVENTS_URL = "https://events-in-paris.cleverapps.io"

class ActivityMain: AppCompatActivity(), ExpandableListView.OnChildClickListener, MyActivityCallback {
    //private lateinit var listViewAdapter : ExpendableListViewAdapter
    private lateinit var categories: ArrayList<String>
    private lateinit var subCategories: HashMap<String, ArrayList<String>>
    //private lateinit var expandableListView: ExpandableListView
    private val eventList = EventList()
    private val favorites = EventList()
    private var fragment: SubCategoryFragment = SubCategoryFragment()
    private lateinit var eventService: EventService
    private lateinit var myButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.favoritesButt)
        myButton.setOnClickListener {
            if (myButton.text == "Favoris") {
                goToFavorites()
            }
            else {
                displayEventList()
            }
        }

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(EVENTS_URL)
            .build()

        eventService = retrofit.create<EventService>(EventService::class.java)

        eventService.getAllEventsSortedByTitle().enqueue(object : Callback<ArrayList<Event>> {
            override fun onResponse(
                call: Call<ArrayList<Event>>,
                response: Response<ArrayList<Event>>
            ) {
                val allEvents = response.body()
                allEvents?.forEach {
                    eventList.addEvent(it)
                }
                displayEventList()
            }
            override fun onFailure(call: Call<ArrayList<Event>>, t: Throwable) {
                Toast.makeText(applicationContext, "Network error", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun displayEventList() {
        val title: TextView = findViewById(R.id.mainActivityTitle)
        title.visibility = View.VISIBLE
        val eventListFragmentTransaction = supportFragmentManager.beginTransaction()
        fragment = SubCategoryFragment.newInstance(this.eventList.getAllEventsSortedByTitle())

        eventListFragmentTransaction.replace(R.id.relativeLayout, fragment)
        eventListFragmentTransaction.commit()

        myButton.text = "Favoris"
    }

    fun goToFavorites() {
        displayFavorites()
    }

    private fun displayFavorites() {
        val title: TextView = findViewById(R.id.mainActivityTitle)
        title.visibility = View.GONE
        val favoritesListFragmentTransaction = supportFragmentManager.beginTransaction()
        fragment = SubCategoryFragment.newInstance(this.favorites.getAllEventsSortedByTitle())

        favoritesListFragmentTransaction.replace(R.id.relativeLayout, fragment)
        favoritesListFragmentTransaction.commit()

        myButton.text = "Events"
    }

    override fun onChildClick(
        parent: ExpandableListView?,
        v: View?,
        groupPosition: Int,
        childPosition: Int,
        id: Long
    ): Boolean {
        displayEventList()

        return false
    }

    override fun goToEvent(event: Event) {
        val intent = Intent(this, EventActivity::class.java)
        intent.putExtra("Event", event)
        this.startActivity(intent)
    }

    override fun addToFavorites(position: Int) {
        val event = eventList.getAllEventsSortedByTitle()[position]
        eventService.addToFav(event.id)
        this.favorites.addEvent(event)
    }
}