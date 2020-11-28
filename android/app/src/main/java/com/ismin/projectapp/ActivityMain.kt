/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ExpandableListView

class ActivityMain: AppCompatActivity(), ExpandableListView.OnChildClickListener {
    //private lateinit var listViewAdapter : ExpendableListViewAdapter
    private lateinit var categories: ArrayList<String>
    private lateinit var subCategories: HashMap<String, ArrayList<String>>
    //private lateinit var expandableListView: ExpandableListView
    private val eventList = EventList()
    private val favorites = EventList()
    private var fragment: SubCategoryFragment = SubCategoryFragment()
    //private val favoritesButton: Button = findViewById(R.id.favoritesButt)

    private val event1: Event = Event("My first event", "03/01/2021")
    private val event2: Event = Event("My second event", "26/10/2021")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //favoritesButton.setOnClickListener { }

        eventList.addEvent(event1)
        eventList.addEvent(event2)
        favorites.addEvent(event2)

        displayEventList()

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

        //favoritesButton.visibility = View.VISIBLE
    }

    fun goToFavorites(view: View) {
        displayFavorites()
    }

    private fun displayFavorites() {
        val favoritesListFragmentTransaction = supportFragmentManager.beginTransaction()
        fragment = SubCategoryFragment.newInstance(this.favorites.getAllEventsSortedByTitle())

        favoritesListFragmentTransaction.replace(R.id.relativeLayout, fragment)
        favoritesListFragmentTransaction.commit()

        //favoritesButton.visibility = View.GONE
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
}