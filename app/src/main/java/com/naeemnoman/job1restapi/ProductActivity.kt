package com.naeemnoman.job1restapi


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.naeemnoman.job1restapi.Adapter.ProductAdapter
import com.naeemnoman.job1restapi.ViewModel.ProductViewModel

class ProductActivity : AppCompatActivity() {
    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productAdapter = ProductAdapter(emptyList())

        val refreshBtn:FloatingActionButton = findViewById(R.id.refreshBtn)
        refreshBtn.setOnClickListener {
            startActivity(Intent(this@ProductActivity, MainActivity::class.java))
            finish()
        }

        val recyclerView : RecyclerView = findViewById(R.id.productRv)
        recyclerView.layoutManager = LinearLayoutManager(this)


        productViewModel.products.observe(this) { products ->
            productAdapter = ProductAdapter(products)
            recyclerView.adapter = productAdapter



        }

    }
}