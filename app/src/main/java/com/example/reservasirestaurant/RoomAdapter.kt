// File: RoomAdapter.kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reservasirestaurant.BerandaFragment
import com.example.reservasirestaurant.R
import com.example.reservasirestaurant.Room

interface OnItemClickListener {
    fun onBookButtonClick(room: Room)
}
class RoomAdapter(
    private val roomList: List<Room>,
    private val clickListener: BerandaFragment
) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivRoomImage)
        val nameTextView: TextView = itemView.findViewById(R.id.tvRoomName)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tvRoomDescription)
        val bookButton: Button = itemView.findViewById(R.id.btnBook)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_room, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val currentRoom = roomList[position]

        holder.imageView.setImageResource(currentRoom.imageResId)
        holder.nameTextView.text = currentRoom.name
        holder.descriptionTextView.text = currentRoom.description

        holder.bookButton.setOnClickListener {
            clickListener.onBookButtonClick(currentRoom)
        }
    }

    override fun getItemCount() = roomList.size
}
