package com.foundrytreasure.main.ui.cart.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.foundrytreasure.R
import com.foundrytreasure.main.ui.cart.interfaces.OnCartItemAddedListener
import com.foundrytreasure.main.ui.cart.interfaces.OnCartItemRemovedListener

class CartItemAdapter(
    val mActivity: Activity,
    val onCartItemAddedListener: OnCartItemAddedListener,
    val onCartItemRemovedListener: OnCartItemRemovedListener
) :
    RecyclerView.Adapter<CartItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItemPrice.text = mActivity.getString(R.string.text_product_price, "8400")
        holder.tvTotalPrice.text = mActivity.getString(R.string.text_product_price_total, "8400")
        val individualPrice =
            holder.tvItemPrice.text.toString().trim().filter { it.isDigit() }
        holder.ivAddItem.setOnClickListener {
            onCartItemAddedListener.onCartAddedClicked(position)
            val itemCount = holder.tvItemCount.text.toString().trim().toInt() + 1
            holder.tvItemCount.text = itemCount.toString()
            holder.ivRemoveItem.isEnabled = true
            val totalPrice = individualPrice.toInt().times(itemCount)
            holder.tvTotalPrice.text =
                mActivity.getString(R.string.text_product_price_total, totalPrice.toString())
        }
        holder.ivRemoveItem.setOnClickListener {
            onCartItemRemovedListener.onCartRemovedClicked(position)
            val itemCount = holder.tvItemCount.text.toString().trim().toInt() - 1
            if (itemCount <= 0) {
                holder.tvItemCount.text = "0"
                holder.ivRemoveItem.isEnabled = false
                holder.tvTotalPrice.text = mActivity.getString(R.string.text_product_price_total, "0")
            } else {
                holder.ivRemoveItem.isEnabled = true
                holder.tvItemCount.text = itemCount.toString()
                val currentPrice =
                    holder.tvTotalPrice.text.toString().trim().filter { it.isDigit() }
                Log.e("CartItemAdapter", "onBindViewHolder: $currentPrice")
                val totalPrice = currentPrice.toLong().minus(individualPrice.toInt())
                Log.e("CartItemAdapter", "onBindViewHolder: $totalPrice")
                holder.tvTotalPrice.text =
                    mActivity.getString(R.string.text_product_price_total, totalPrice.toString())
            }
        }
        holder.ivRemoveProduct.setOnClickListener {
            onCartItemRemovedListener.onCartRemovedClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAddItem: AppCompatImageView = itemView.findViewById(R.id.iv_add_item)
        val ivRemoveItem: AppCompatImageView = itemView.findViewById(R.id.iv_remove_item)
        val ivRemoveProduct: AppCompatImageView = itemView.findViewById(R.id.iv_remove_product)
        val tvItemCount: AppCompatTextView = itemView.findViewById(R.id.tv_item_count)
        val tvTotalPrice: AppCompatTextView = itemView.findViewById(R.id.tv_total_price)
        val tvItemPrice: AppCompatTextView = itemView.findViewById(R.id.tv_product_price)
    }
}