package com.example.ecomarket

import com.example.ecomarket.base.BaseDialog
import com.example.ecomarket.data.model.Product
import com.example.ecomarket.databinding.FragmentProductBottomSheetBinding
import com.example.ecomarket.ui.home.product.ProductFragment.Companion.KEY_TO_INFO
import com.example.ecomarket.utils.loadImage

class ProductBottomSheetFragment : BaseDialog<FragmentProductBottomSheetBinding>() {

    private var product: Product? = null

    override fun initViews() {
        super.initViews()
        product = arguments?.getSerializable(KEY_TO_INFO) as Product
        with(binding) {
            tvProductName.text = product?.title
            product?.image?.let { ivProduct.loadImage(it) }
            tvDescription.text = product?.description
            tvPrice.text = product?.price
        }
    }

    override fun inflateViewBinding(): FragmentProductBottomSheetBinding {
        return FragmentProductBottomSheetBinding.inflate(layoutInflater)
    }
}