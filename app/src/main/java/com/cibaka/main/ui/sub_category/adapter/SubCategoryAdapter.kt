package com.cibaka.main.ui.sub_category.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cibaka.R

class SubCategoryAdapter(val activity: Activity) :
    RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivCategory.setBackgroundResource(R.drawable.ic_category)
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_go_to_product_list)
        }
    }

    override fun getItemCount(): Int {
        return 4
    }

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivCategory: AppCompatImageView = itemView.findViewById(R.id.iv_category)
        var tvCategoryName: AppCompatTextView = itemView.findViewById(R.id.tv_category_name)
        var tvCategoryPrice: AppCompatTextView = itemView.findViewById(R.id.tv_category_price)
    }
}