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
/*
Даггер - ген.зависимости через фабрики берет у одних зависимостей добав к другим
нужен чтобы не дублировать код и не создавать конструкторы

когда апк запушен через дагер
 */
