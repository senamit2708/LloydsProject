package com.example.lloydsproject.userModule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lloydsproject.userModule.repository.NewUserRepository
import java.lang.IllegalArgumentException

class NewUserViewModelFactory(val repository: NewUserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewUserViewModel::class.java)){
            return NewUserViewModel(repository) as T
        }
        throw IllegalArgumentException("no such viewmodel found")
    }
}