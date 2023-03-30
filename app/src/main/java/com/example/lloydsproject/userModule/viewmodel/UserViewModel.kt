package com.example.lloydsproject.userModule.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.lloydsproject.userModule.model.UserData
import com.example.lloydsproject.userModule.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = UserViewModel::class.java.simpleName
    private val userRepository: UserRepository
    private var mSelectedUserData: MutableLiveData<UserData?> = MutableLiveData()

    init {
        userRepository = UserRepository(application)
    }

    fun loadUserDataFromServer() {
        viewModelScope.launch {
            userRepository.loadUserDataFromServer()
        }
    }

    fun retrieveData(): LiveData<List<UserData>> {
        return userRepository.getAllUser()
    }

    fun setSelectedUserDetail(user: UserData?) {
        mSelectedUserData.value = user
    }

    fun getSelectedUserDetail(): LiveData<UserData?> {
        return mSelectedUserData
    }
}