/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpendableListViewAdapter internal constructor(private val context: Context,
                                                     private val categories: ArrayList<String>,
                                                     private val subCategories: HashMap<String, ArrayList<String>>)
    : BaseExpandableListAdapter() {


    public fun getCategories(): ArrayList<String> { return categories }

    override fun getGroup(groupPosition: Int): Any { return categories[groupPosition] }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean { return true }

    override fun hasStableIds(): Boolean { return false }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val categoryTitle = getGroup(groupPosition) as String

        if(convertView == null) {
            val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflator.inflate(R.layout.row_category, null)
        }

        val categoryName = convertView!!.findViewById<TextView>(R.id.categoryName)
        categoryName.setText(categoryTitle)

        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.subCategories[this.categories[groupPosition]]!!.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any { return this.subCategories[this.categories[groupPosition]]!![childPosition] }

    override fun getGroupId(groupPosition: Int): Long { return groupPosition.toLong() }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val subCategoryTitle = getChild(groupPosition, childPosition) as String

        if(convertView == null) {
            val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflator.inflate(R.layout.row_small_category, null)
        }

        val subCategoryName = convertView!!.findViewById<TextView>(R.id.smallCategory)
        subCategoryName.text = subCategoryTitle

        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long { return childPosition.toLong() }

    override fun getGroupCount(): Int { return categories.size }
}