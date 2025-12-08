package com.example.reservasirestaurant.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reservasirestaurant.DrinksModel
import com.example.reservasirestaurant.R

class DrinksAdapter(private val DrinksList: List<DrinksModel>) :
    RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>() {

    class DrinksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgDrinks: ImageView = itemView.findViewById(R.id.imgDrinks)
        val txtDrinksName: TextView = itemView.findViewById(R.id.txtDrinksName)
        val txtMenuPrice: TextView = itemView.findViewById(R.id.txtDrinksPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_drinks, parent, false)
        return DrinksViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        val item = DrinksList[position]
        holder.imgDrinks.setImageResource(item.imageRes)
        holder.txtDrinksName.text = item.name
        holder.txtDrinksName.text = item.price
    }

    override fun getItemCount() = DrinksList.size
}
