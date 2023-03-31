package com.cibaka.main.ui.my_orders.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cibaka.R

class OrdersAdapter(val activity: Activity) :
    RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_orders, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_go_to_order_details)
        }
    }

    override fun getItemCount(): Int {
        return 4
    }

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}