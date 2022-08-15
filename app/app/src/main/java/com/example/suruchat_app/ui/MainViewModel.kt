package com.example.suruchat_app.ui

import androidx.lifecycle.*
import com.example.suruchat_app.data.local.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val userPreferences: UserPreferences
) : ViewModel() {

    private var _token = MutableLiveData<String>()
    var token: LiveData<String> = _token
    private var _userId = MutableLiveData<String>()
    var userId: LiveData<String> = _userId
    private var _userImage = MutableLiveData<String>()
    var userImage: LiveData<String> = _userImage
    private var _userName = MutableLiveData<String>()
    var userName: LiveData<String> = _userName
    private var _privateKey = MutableLiveData<String>()
    var privateKey: LiveData<String> = _privateKey
    private var _loginTime = MutableLiveData<Long>()
    var loginTime: LiveData<Long> = _loginTime

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        viewModelScope.launch {
            token = userPreferences.userLoginToken.asLiveData()
            userId = userPreferences.userId.asLiveData()
            userImage = userPreferences.userImage.asLiveData()
            userName = userPreferences.userName.asLiveData()
            privateKey = userPreferences.privateKey.asLiveData()
            loginTime = userPreferences.loginTime.asLiveData()
        }
    }
}