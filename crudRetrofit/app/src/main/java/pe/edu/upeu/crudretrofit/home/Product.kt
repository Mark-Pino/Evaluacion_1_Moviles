package pe.edu.upeu.crudretrofit.home

import com.squareup.moshi.Json

data class Product(
    @field:Json(name = "_id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "price")
    val price: Double
)

data class ProductDto(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "price")
    val price: Double
)

