package com.example.ecomarket.ui.home.product

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ecomarket.R
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.data.model.Category
import com.example.ecomarket.data.model.Product
import com.example.ecomarket.databinding.FragmentProductBinding
import com.example.ecomarket.ui.home.HomeFragment.Companion.KEY
import com.example.ecomarket.ui.home.HomeViewModel
import com.example.ecomarket.ui.home.product.adapter.ProductAdapter
import com.example.ecomarket.ui.home.product.adapter.ProductCategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : BaseFragment<FragmentProductBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { ProductCategoryAdapter() }
    private val productAdapter by lazy { ProductAdapter(this::onClick) }
    private var category: Category? = null

    override fun initViews() {
        super.initViews()
        category = arguments?.getSerializable(KEY) as Category
        binding.rvCategory.adapter = adapter
        binding.rvProduct.adapter = productAdapter
    }

    override fun initListener() {
        super.initListener()
        binding.icArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun onClick(product: Product) {
        findNavController().navigate(R.id.productBottomSheetFragment, bundleOf(KEY_TO_INFO to product))
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.getCategories()
        viewModel.categoryResponse.observe(viewLifecycleOwner) {
            adapter.addList(it)
        }
        viewModel.getProducts()
        viewModel.productResponse.observe(viewLifecycleOwner) {
            productAdapter.addList(it)
        }
    }

    override fun inflateViewBinding(): FragmentProductBinding {
        return FragmentProductBinding.inflate(layoutInflater)
    }

    companion object {
        const val KEY_TO_INFO = "KEY_TO_INFO"
    }
}