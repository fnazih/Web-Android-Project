package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubCategoryActivity: AppCompatActivity() {
    private lateinit var subCategoryName: TextView
    private lateinit var rcvEventList: RecyclerView
    private lateinit var eventAdapter: recyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        this.subCategoryName = findViewById(R.id.subCategoryTitleViewId)
        this.rcvEventList = findViewById(R.id.recyclerView)

        subCategoryName.text = intent.getStringExtra(Intent.EXTRA_TEXT).toString()
    }
}
