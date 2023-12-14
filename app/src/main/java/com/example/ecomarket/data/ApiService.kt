package com.example.ecomarket.data

import com.example.ecomarket.data.model.Category
import com.example.ecomarket.data.model.Product
import retrofit2.http.GET

interface ApiService {

    @GET("product-category-list")
    suspend fun getCategories(): List<Category>

    @GET("product-list")
    suspend fun getProducts(): List<Product>
}