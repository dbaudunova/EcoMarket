package com.example.ecomarket.repository

import com.example.ecomarket.data.ApiService
import com.example.ecomarket.data.model.Category
import com.example.ecomarket.data.model.Product
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCategories(): List<Category> {
        return apiService.getCategories()
    }

    suspend fun getProducts(): List<Product> {
        return apiService.getProducts()
    }
}