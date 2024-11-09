package com.naeemnoman.job1restapi


import android.icu.text.CaseMap.Title

data class Product(

    val images:List<String>,
    val title:String,
    val price:Double,
    val description:String

)