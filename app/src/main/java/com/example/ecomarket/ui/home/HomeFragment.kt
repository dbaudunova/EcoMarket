package com.example.ecomarket.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ecomarket.R
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.data.model.Category
import com.example.ecomarket.databinding.FragmentHomeBinding
import com.example.ecomarket.ui.home.adapter.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.getCategories()
        viewModel.categoryResponse.observe(viewLifecycleOwner) {
            adapter.addList(it)
        }
    }

    private fun onClick(category: Category) {
        findNavController().navigate(R.id.productFragment, bundleOf(KEY to category))
    }

    override fun initViews() {
        super.initViews()
        adapter = CategoryAdapter(this::onClick)
        binding.rvCategory.adapter = adapter
    }

    override fun inflateViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    companion object {
        const val KEY = "category"
    }
}