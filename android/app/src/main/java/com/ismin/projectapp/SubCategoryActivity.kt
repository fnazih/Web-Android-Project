package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.TextView

class SubCategoryActivity: AppCompatActivity() {
    private lateinit var subCategoryName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_category)

        this.subCategoryName = findViewById(R.id.subCategoryTitleViewId)

        subCategoryName.text = intent.getStringExtra(Intent.EXTRA_TEXT).toString()
    }
}

