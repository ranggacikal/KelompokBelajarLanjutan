package ranggacikal.co.id.kelompokbelajarlanjutan.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ranggacikal.co.id.kelompokbelajarlanjutan.model.UserResponse
import ranggacikal.co.id.kelompokbelajarlanjutan.repository.UserRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {

    val userList: MutableLiveData<UserResponse> = MutableLiveData()
    val repository = UserRepositoryImpl()

    fun getDataUser(): LiveData<UserResponse> {
        repository.getDataUser().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    userList.postValue(response.body())
                } else {
                    userList.postValue(emptyArray<UserResponse>())
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return userList
    }

    private fun <T> MutableLiveData<T>.postValue(emptyArray: Array<T>): Array<T> {
        return emptyArray
    }

}