package ranggacikal.co.id.kelompokbelajarlanjutan.model

import com.google.gson.annotations.SerializedName

data class UserByIdResponse(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("dataUserById")
	val dataUserById: List<DataUserByIdItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)