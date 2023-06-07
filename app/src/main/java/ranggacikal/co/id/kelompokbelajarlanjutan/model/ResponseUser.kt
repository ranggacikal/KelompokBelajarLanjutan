package ranggacikal.co.id.kelompokbelajarlanjutan.model

import com.google.gson.annotations.SerializedName

data class ResponseUser(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("dataUser")
	val dataUser: List<DataUserItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)