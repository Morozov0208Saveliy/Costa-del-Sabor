package com.example.costadelsabor.retrofit

import retrofit2.http.GET

interface ProductApi {
    @GET("products/1")
    suspend fun getProducts(): List<Product>

}