/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                val allBooks = response.body()
                allBooks?.forEach {
                    eventList.addEvent(it)
                }
                displayEventList()
            }
            override fun onFailure(call: Call<ArrayList<Event>>, t: Throwable) {
                Toast.makeText(applicationContext, "Network error", Toast.LENGTH_LONG).show()
            }
        })

        //updateList()
        //expandableListView = findViewById(R.id.expendableListView)
        //listViewAdapter = ExpendableListViewAdapter(this, categories, subCategories)
        //expandableListView.setAdapter(listViewAdapter)
        //expandableListView.setOnChildClickListener(this)
    }

    private fun updateList() {      //fct a adapter qd on aura la bdd
        categories = ArrayList()
        subCategories = HashMap()

        //Test de la liste avec des elements au hasard
        categories.add("Categorie 1")
        categories.add("Categorie 2")
        categories.add("Categorie 3")
        categories.add("Categorie 4")

        val subCategory1: ArrayList<String> = ArrayList()
        subCategory1.add("SubCategory1")
        subCategory1.add("SubCategory2")
        subCategory1.add("SubCategory3")
        subCategory1.add("SubCategory4")

        val subCategory2: ArrayList<String> = ArrayList()
        subCategory2.add("SubCategory1")
        subCategory2.add("SubCategory2")
        subCategory2.add("SubCategory3")
        subCategory2.add("SubCategory4")

        val subCategory3: ArrayList<String> = ArrayList()
        subCategory3.add("SubCategory1")
        subCategory3.add("SubCategory2")
        subCategory3.add("SubCategory3")
        subCategory3.add("SubCategory4")

        val subCategory4: ArrayList<String> = ArrayList()
        subCategory4.add("SubCategory1")
        subCategory4.add("SubCategory2")
        subCategory4.add("SubCategory3")
        subCategory4.add("SubCategory4")

        this.subCategories[categories[0]] = subCategory1
        this.subCategories[categories[1]] = subCategory2
        this.subCategories[categories[2]] = subCategory3
        this.subCategories[categories[3]] = subCategory4
    }

    private fun displayEventList() {
        val eventListFragmentTransaction = supportFragmentManager.beginTransaction()
        fragment = SubCategoryFragment.newInstance(this.eventList.getAllEventsSortedByTitle())

        eventListFragmentTransaction.replace(R.id.relativeLayout, fragment)
        eventListFragmentTransaction.commit()

        favoritesButt.visibility = View.VISIBLE
    }

    fun goToFavorites(view: View) {
        displayFavorites()
    }

    private fun displayFavorites() {
        val favoritesListFragmentTransaction = supportFragmentManager.beginTransaction()
        fragment = SubCategoryFragment.newInstance(this.favorites.getAllEventsSortedByTitle())

        favoritesListFragmentTransaction.replace(R.id.relativeLayout, fragment)
        favoritesListFragmentTransaction.commit()

        favoritesButt.visibility = View.GONE
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
        val pickedEvent = event.id
        intent.putExtra("pickedEvent", pickedEvent)
        System.out.println(pickedEvent)
        this.startActivity(intent)
    }
}