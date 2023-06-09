package ranggacikal.co.id.kelompokbelajarlanjutan.repository

import ranggacikal.co.id.kelompokbelajarlanjutan.model.LoginResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.model.RegisterResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.model.ResponseUser
import ranggacikal.co.id.kelompokbelajarlanjutan.model.UserByIdResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.network.NetworkConfig
import retrofit2.Call

class UserRepositoryImpl : UserRepository {
    override fun requestRegister(
        idUser: String?,
        username: String?,
        password: String?,
        namaLengkap: String?
    ): Call<RegisterResponse> {
        return NetworkConfig.getApiService().registerUser(idUser, username, password, namaLengkap)
    }

    override fun loginRequest(username: String?, password: String?): Call<LoginResponse> {
        return NetworkConfig.getApiService().loginUser(username, password)
    }

    override fun getDataUser(): Call<ResponseUser> {
        return NetworkConfig.getApiService().getUser()
    }

    override fun getDataUserById(id_user: String?): Call<UserByIdResponse> {
        return NetworkConfig.getApiService().getUserById(id_user)
    }
}