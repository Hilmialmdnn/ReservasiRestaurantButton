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

    // --- 2. onCreateViewHolder ---
    // Dipanggil saat RecyclerView perlu membuat item baru (inflate layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        // Proses "menghidupkan" layout item_room.xml menjadi View
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_room, parent, false)
        return RoomViewHolder(view)
    }

    // --- 3. onBindViewHolder (Inti Pengisian Data & Klik) ---
    // Dipanggil untuk mengisi data ke dalam item yang sudah dibuat
    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val currentRoom = roomList[position] // Ambil data Room pada posisi saat ini

        // Mengisi tampilan (view) dengan data dari objek Room
        holder.imageView.setImageResource(currentRoom.imageResId) // Mengisi Gambar dari ID
        holder.nameTextView.text = currentRoom.name              // Mengisi Nama
        holder.descriptionTextView.text = currentRoom.description // Mengisi Deskripsi

        // Menambahkan fungsi klik pada Tombol 'Pesan Sekarang'
        holder.bookButton.setOnClickListener {
            // Memanggil fungsi interface, mengirimkan objek Room yang diklik
            clickListener.onBookButtonClick(currentRoom)
        }
    }

    // --- 4. getItemCount ---
    // Memberi tahu RecyclerView berapa banyak item yang harus ditampilkan
    override fun getItemCount() = roomList.size
}
