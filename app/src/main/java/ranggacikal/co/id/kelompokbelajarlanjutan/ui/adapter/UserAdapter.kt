package ranggacikal.co.id.kelompokbelajarlanjutan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ranggacikal.co.id.kelompokbelajarlanjutan.databinding.ItemDataUserBinding
import ranggacikal.co.id.kelompokbelajarlanjutan.model.UserResponse

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    val userList: MutableList<UserResponse> = mutableListOf()

    fun addDataUser(list: List<UserResponse>){
        userList.clear()
        userList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(ItemDataUserBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    class UserViewHolder(private val binding: ItemDataUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(userList: UserResponse) = binding.run {
            tvItemNamaUser.text = userList.dataUser[0].namaLengkap
        }
    }
}