package ranggacikal.co.id.kelompokbelajarlanjutan.network

import ranggacikal.co.id.kelompokbelajarlanjutan.model.LoginResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.model.RegisterResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.model.ResponseUser
import ranggacikal.co.id.kelompokbelajarlanjutan.model.UserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun registerUser(
        @Field("id_user") idUser: String?,
        @Field("username") username: String?,
        @Field("password") password: String?,
        @Field("nama_lengkap") namaLengkap: String?
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Call<LoginResponse>

    @GET("getDataUser")
    fun getUser(): Call<ResponseUser>
}