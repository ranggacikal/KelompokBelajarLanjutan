package ranggacikal.co.id.kelompokbelajarlanjutan.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ranggacikal.co.id.kelompokbelajarlanjutan.model.UserByIdResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.repository.UserRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel: ViewModel() {
    val repository = UserRepositoryImpl()
    val userByIdObserver: MutableLiveData<UserByIdResponse> = MutableLiveData()

    fun requestUserById(idUser: String): LiveData<UserByIdResponse> {
        repository.getDataUserById(idUser).enqueue(object : Callback<UserByIdResponse>{
            override fun onResponse(call: Call<UserByIdResponse>, response: Response<UserByIdResponse>) {
                if (response.isSuccessful) userByIdObserver.value = response.body()
                else userByIdObserver.value = UserByIdResponse(status = 0)
            }

            override fun onFailure(call: Call<UserByIdResponse>, t: Throwable) {
                t.printStackTrace()
                userByIdObserver.value = UserByIdResponse(pesan = t.message)
            }
        })
        return userByIdObserver
    }
}