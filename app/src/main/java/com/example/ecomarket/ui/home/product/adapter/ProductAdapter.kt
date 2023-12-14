package com.example.ecomarket.ui.home.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ecomarket.data.model.Product
import com.example.ecomarket.databinding.ItemProductBinding
import com.example.ecomarket.utils.loadImage

class ProductAdapter : Adapter<ProductAdapter.ProductViewHolder>() {

    private val productList = ArrayList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.apply {
                ivProduct.loadImage(product.image)
                tvProductName.text = product.description
                tvPrice.text = product.price
            }
        }
    }
}