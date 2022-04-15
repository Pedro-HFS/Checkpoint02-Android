package br.com.pedrosantos.myapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.pedrosantos.myapp.model.Food

class ViewActivity : AppCompatActivity() {

    private lateinit var foodSelected:Food

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        foodSelected = intent.getSerializableExtra("data") as Food

        val tvFoodName: TextView = findViewById(R.id.tvFoodName)
        val tvFoodWeight: TextView = findViewById(R.id.tvFoodWeight)
        val tvFoodPrice: TextView = findViewById(R.id.tvFoodPrice)

        tvFoodName.text = foodSelected.name
        tvFoodWeight.text = foodSelected.weight
        tvFoodPrice.text = foodSelected.price.toString()
    }
}