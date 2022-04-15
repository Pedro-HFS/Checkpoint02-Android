package br.com.pedrosantos.myapp

import android.content.Intent
import android.util.Log
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.pedrosantos.myapp.adapter.ItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity(), ItemAdapter.OnFoodClickListener {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Log.i("DATA", Database.foodList.toString())
        val rvFoodList:RecyclerView = findViewById(R.id.rvFoodList)
        rvFoodList.layoutManager = LinearLayoutManager(this)

        rvFoodList.adapter = ItemAdapter(Database.foodList, this)

        val fabRegisterFood:FloatingActionButton = findViewById(R.id.fabRegisterFood)
        fabRegisterFood.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onFoodClick(foodPosition: Int) {
        val intent = Intent(this, ViewActivity::class.java)
        intent.putExtra("data", Database.foodList[foodPosition])
        startActivity(intent)
    }
}