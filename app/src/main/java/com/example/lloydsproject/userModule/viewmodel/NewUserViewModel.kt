package com.example.lloydsproject.userModule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lloydsproject.userModule.model.UserData
import com.example.lloydsproject.userModule.repository.NewUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewUserViewModel @Inject constructor(val newUserRepository: NewUserRepository): ViewModel() {
    fun saveUser(user: UserData) {
        viewModelScope.launch {
            newUserRepository.saveUserData(user)
        }
    }


    companion object {
        private val TAG = NewUserViewModel::class.java.simpleName
    }
}