package me.dio.web.meuportfliogithub.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GitHubApi {

    private lateinit var gitHunService:GitHubService

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    private fun config(): Retrofit = Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

    fun retrofitApi(): GitHubService = config().create()
}