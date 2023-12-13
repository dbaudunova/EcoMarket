package com.example.ecomarket.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ecomarket.data.model.Category
import com.example.ecomarket.databinding.ItemCategoryBinding
import com.example.ecomarket.utils.loadImage

class CategoryAdapter: Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categoryList = ArrayList<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = categoryList.size
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.tvCategory.text = category.name
            category.image?.let { binding.ivCategory.loadImage(it) }
        }
    }
}