package com.example.donemodevi.data.repository

import com.example.donemodevi.data.api.RetrofitBuilder

class MainRepository {
    suspend fun getUsers() = RetrofitBuilder.api.getUsers()
}