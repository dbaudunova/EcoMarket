package com.example.ecomarket.data.model

import java.io.Serializable

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: Int,
    val image: String,
    val quantity: Int,
    val price: String
) : Serializable