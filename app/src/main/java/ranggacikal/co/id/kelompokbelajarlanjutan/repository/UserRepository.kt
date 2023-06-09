package ranggacikal.co.id.kelompokbelajarlanjutan.repository

import ranggacikal.co.id.kelompokbelajarlanjutan.model.LoginResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.model.RegisterResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.model.ResponseUser
import ranggacikal.co.id.kelompokbelajarlanjutan.model.UserByIdResponse
import retrofit2.Call

interface UserRepository {
    fun requestRegister(
        idUser: String?,
        username: String?,
        password: String?,
        namaLengkap: String?
    ): Call<RegisterResponse>

    fun loginRequest(
        username: String?,
        password: String?
    ): Call<LoginResponse>

    fun getDataUser(): Call<ResponseUser>

    fun getDataUserById(id_user: String?): Call<UserByIdResponse>
}