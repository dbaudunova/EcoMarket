package com.example.ecomarket.ui.home.product.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ecomarket.data.model.Category
import com.example.ecomarket.databinding.ItemProductCategoryBinding

class ProductCategoryAdapter : Adapter<ProductCategoryAdapter.ProductCategoryViewHolder>() {

    private var list = ArrayList<Category>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Category>) {
        this.list = list as ArrayList<Category>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        return ProductCategoryViewHolder(
            ItemProductCategoryBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ProductCategoryViewHolder(private val binding: ItemProductCategoryBinding) :
        ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.tvCategory.text = category.name
        }
    }
}