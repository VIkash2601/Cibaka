package com.cibaka.main.ui.home.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.cibaka.R

class HomeTrendingProductAdapter(val activity: Activity) : RecyclerView.Adapter<HomeTrendingProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_trending_products, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivTrendingProduct.setBackgroundResource(R.drawable.ic_trending_product)
    }

    override fun getItemCount(): Int {
        return 4
    }

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivTrendingProduct: AppCompatImageView = itemView.findViewById(R.id.iv_trending_products)
        var tvTrendingProductName: AppCompatTextView = itemView.findViewById(R.id.tv_trending_products_name)
        var tvTrendingProductPrice: AppCompatTextView = itemView.findViewById(R.id.tv_trending_products_price)
    }
}