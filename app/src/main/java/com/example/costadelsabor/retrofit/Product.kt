package com.example.costadelsabor.retrofit

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val category: String,
    val images: List<String>
)
