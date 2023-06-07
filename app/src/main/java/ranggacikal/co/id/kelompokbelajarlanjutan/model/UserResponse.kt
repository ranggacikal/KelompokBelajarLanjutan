package ranggacikal.co.id.kelompokbelajarlanjutan.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val pesan: String? = null,
    val dataUser: List<DataUserItem>,
    val status: Int? = null
)

data class DataUserItem(
    val password: String? = null,
    val namaLengkap: String? = null,
    val idUser: Any? = null,
    val username: String? = null
)

