package com.example.ecomarket.ui.home.product

import androidx.fragment.app.viewModels
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.data.model.Category
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
    private val productAdapter by lazy { ProductAdapter() }
    private var category: Category? = null

    override fun initViews() {
        super.initViews()
        category = arguments?.getSerializable(KEY) as Category
        binding.rvCategory.adapter = adapter
        binding.rvProduct.adapter = productAdapter

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
}