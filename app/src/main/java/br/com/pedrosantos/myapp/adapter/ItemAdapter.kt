package br.com.pedrosantos.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.pedrosantos.myapp.model.Food
import br.com.pedrosantos.myapp.R

class ItemAdapter (val data:List<Food>,
         val onFoodClickListener : OnFoodClickListener):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


   class ItemViewHolder(view: View,
   val onFoodClickListener : OnFoodClickListener):RecyclerView.ViewHolder(view), View.OnClickListener{

     val tvFoodName:TextView = view.findViewById(R.id.tvFoodName)
     val tvFoodWeight:TextView = view.findViewById(R.id.tvFoodWeight)
     val tvFoodPrice:TextView = view.findViewById(R.id.tvFoodPrice)
     val cvItemList:CardView = view.findViewById(R.id.cvItemList)

     init {
         cvItemList.setOnClickListener(this)
     }

     override fun onClick(v: View?){
         onFoodClickListener.onFoodClick(adapterPosition)
     }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(adapterLayout, onFoodClickListener)
    }


   override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
       val food = data[position]
       holder.tvFoodName.text = food.name
       holder.tvFoodWeight.text = food.weight
       holder.tvFoodPrice.text = food.price.toString()
   }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnFoodClickListener{
        fun onFoodClick(foodPosition: Int)
    }
}