package me.dio.web.meuportfliogithub.api

import me.dio.web.meuportfliogithub.domain.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}/repos")
    fun listRepository(@Path("user") user: String): Call<List<User>>
}

