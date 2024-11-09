package com.naeemnoman.job1restapi



import retrofit2.http.GET

interface ApiService {


    @GET("products")
    suspend fun getProducts(): List<Product>

}
