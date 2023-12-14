package com.example.ecomarket.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomarket.data.model.Category
import com.example.ecomarket.data.model.Product
import com.example.ecomarket.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val categoryResponse: MutableLiveData<List<Category>> = MutableLiveData()
    val productResponse: MutableLiveData<List<Product>> = MutableLiveData()

    fun getCategories() {
        viewModelScope.launch {
            val response = repository.getCategories()
            categoryResponse.value = response
        }
    }

    fun getProducts() {
        viewModelScope.launch {
            val response = repository.getProducts()
            productResponse.value = response
        }
    }
}