package ranggacikal.co.id.kelompokbelajarlanjutan.repository

import ranggacikal.co.id.kelompokbelajarlanjutan.model.RegisterResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.model.UserResponse
import retrofit2.Call

interface UserRepository {
    fun requestRegister(
        idUser: String?,
        username: String?,
        password: String?,
        namaLengkap: String?
    ): Call<RegisterResponse>

    fun getDataUser(): Call<UserResponse>
}