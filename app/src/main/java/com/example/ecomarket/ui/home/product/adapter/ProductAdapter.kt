package com.example.ecomarket.ui.home.product.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ecomarket.data.model.Product
import com.example.ecomarket.databinding.ItemProductBinding
import com.example.ecomarket.utils.loadImage

class ProductAdapter(val onClick: (Product) -> Unit) : Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList = ArrayList<Product>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Product>) {
        productList = list as ArrayList<Product>
        notifyDataSetChanged()
    }

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
                binding.ivProduct.loadImage(product.image)
                tvProductName.text = product.title
                tvPrice.text = product.price
            }

            binding.btnAdd.setOnClickListener {
                binding.btnAdd.visibility = GONE
                binding.btnMinus.visibility = VISIBLE
                binding.tvNumber.text = VISIBLE.toString()
                binding.btnPlus.visibility = VISIBLE
            }

            itemView.setOnClickListener {
                onClick(product)
            }
        }
    }
}