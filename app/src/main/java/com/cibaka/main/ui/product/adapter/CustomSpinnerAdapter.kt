package com.cibaka.main.ui.product.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.cibaka.R
import com.cibaka.main.ui.product.dto.Size

class CustomSpinnerAdapter(val mActivity: Activity, val list: ArrayList<Size>): BaseAdapter() {

    private val inflater: LayoutInflater = mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.custom_spinner_item, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.label.text = list[position].size

        return view
    }

    private class ItemHolder(row: View?) {
        val label: AppCompatTextView = row?.findViewById(R.id.tv_spinner_item) as AppCompatTextView
    }
}