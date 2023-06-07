package ranggacikal.co.id.kelompokbelajarlanjutan.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ranggacikal.co.id.kelompokbelajarlanjutan.databinding.ItemDataUserBinding
import ranggacikal.co.id.kelompokbelajarlanjutan.model.DataUserItem
import ranggacikal.co.id.kelompokbelajarlanjutan.model.UserResponse

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    val dataUser: MutableList<DataUserItem> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataUser(list: List<DataUserItem>?){
        dataUser.clear()
        list?.let { dataUser.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(ItemDataUserBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(dataUser[position])
    }

    override fun getItemCount(): Int = dataUser.size

    class UserViewHolder(private val binding: ItemDataUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(userList: DataUserItem) = binding.run {
            tvItemNamaUser.text = userList.namaLengkap
        }
    }
}