package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import kotlinx.android.synthetic.main.activity_main.*

class ActivityMain: AppCompatActivity() {
    private lateinit var listViewAdapter : ExpendableListViewAdapter
    private lateinit var categories: ArrayList<String>
    private lateinit var subCategories: HashMap<String, ArrayList<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showList()

        listViewAdapter = ExpendableListViewAdapter(this, categories, subCategories)
        expendableListView.setAdapter(listViewAdapter)

        showList()
    }

    private fun showList() {
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

        subCategories[categories[0]] = subCategory1
        subCategories[categories[1]] = subCategory2
        subCategories[categories[2]] = subCategory3
        subCategories[categories[3]] = subCategory4
    }


    public fun onChildClickListener(parent: ExpandableListView, v: View, groupPosition: Int, childPosition: Int, id: Long) {
        val intent = Intent(this, SubCategoryActivity::class.java)
        intent.putExtra(Intent.EXTRA_TEXT, listViewAdapter.getChild(groupPosition, childPosition).toString())
        this.startActivity(intent)
    }
}