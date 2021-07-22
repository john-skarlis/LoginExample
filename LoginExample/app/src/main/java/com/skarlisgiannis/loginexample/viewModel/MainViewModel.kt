package com.skarlisgiannis.loginexample.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skarlisgiannis.loginexample.model.LoginPost
import com.skarlisgiannis.loginexample.model.LoginResponse
import com.skarlisgiannis.loginexample.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<LoginResponse>> = MutableLiveData()


    fun login(post: LoginPost){
        viewModelScope.launch {
            val response = repository.login(post)
            myResponse.value = response
        }
    }
}