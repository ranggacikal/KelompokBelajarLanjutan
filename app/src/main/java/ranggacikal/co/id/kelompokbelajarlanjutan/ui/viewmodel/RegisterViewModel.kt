package ranggacikal.co.id.kelompokbelajarlanjutan.ui.viewmodel

import android.app.ProgressDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ranggacikal.co.id.kelompokbelajarlanjutan.model.RegisterResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.repository.UserRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    val repository = UserRepositoryImpl()
    val registerObserver: MutableLiveData<RegisterResponse> = MutableLiveData()

    fun requestRegister(
        idUser: String,
        username: String,
        password: String,
        namaLengkap: String
    ): LiveData<RegisterResponse> {
        repository.requestRegister(idUser, username, password, namaLengkap).enqueue(object : Callback<RegisterResponse> {

            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) registerObserver.value = response.body()
                else registerObserver.value = RegisterResponse(sukses = false)
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                t.printStackTrace()
                registerObserver.value = RegisterResponse(pesan = t.message)
            }

        })
        return registerObserver
    }
}