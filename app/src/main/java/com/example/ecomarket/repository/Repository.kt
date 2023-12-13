package com.example.ecomarket.repository

import com.example.ecomarket.data.ApiService
import com.example.ecomarket.data.model.Category
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCategories(): Response<Category> {
        return apiService.getCategories()
    }
}