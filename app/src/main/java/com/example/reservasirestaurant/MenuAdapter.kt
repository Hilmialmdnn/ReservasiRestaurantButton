package com.example.reservasirestaurant.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reservasirestaurant.R
import com.example.reservasirestaurant.models.MenuModel

class MenuAdapter(private val menuList: List<MenuModel>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenu: ImageView = itemView.findViewById(R.id.imgMenu)
        val txtMenuName: TextView = itemView.findViewById(R.id.txtMenuName)
        val txtMenuPrice: TextView = itemView.findViewById(R.id.txtMenuPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menuList[position]
        holder.imgMenu.setImageResource(item.imageRes)
        holder.txtMenuName.text = item.name
        holder.txtMenuPrice.text = item.price
    }

    override fun getItemCount() = menuList.size
}
