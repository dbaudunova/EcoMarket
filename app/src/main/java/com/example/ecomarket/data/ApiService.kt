package com.example.ecomarket.data

import com.example.ecomarket.data.model.Category
import retrofit2.http.GET

interface ApiService {

    @GET("product-category-list")
    suspend fun getCategories(): List<Category>
}