package com.naeemnoman.job1restapi.ViewModel



import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.naeemnoman.job1restapi.ApiInstance

import com.naeemnoman.job1restapi.ApiService
import com.naeemnoman.job1restapi.Product
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {


    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        viewModelScope.launch{
            fetchProducts()
        }


    }

    private suspend fun fetchProducts() {
        try {
            val response =ApiInstance.apiService.getProducts()

            _products.postValue(response)
        }catch (e: Exception){

        }
    }

}