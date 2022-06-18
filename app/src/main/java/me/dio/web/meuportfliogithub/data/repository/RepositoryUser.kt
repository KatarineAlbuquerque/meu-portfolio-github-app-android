package me.dio.web.meuportfliogithub.data.repository

import android.util.Log
import me.dio.web.meuportfliogithub.api.GitHubApi
import me.dio.web.meuportfliogithub.domain.User
import retrofit2.Response

class RepositoryUser(private val apiGitHun: GitHubApi) {

    private val repositories = arrayListOf<User>()
    private lateinit var user: String

    companion object {
        const val error = "ERROR_GITHUB"
        const val userName = "KatarineAlbuquerque"
    }

    fun getRepositories(): List<User> {

        val request = apiGitHun.retrofitApi().listRepository(userName).execute()

        if(request.isSuccessful) {
            request.body()?.let {
                repositories.addAll(it)
            }
        }
        else {
            errorMessage(request)
        }
        // order sort desc id
        return repositories.sortedByDescending { it.id }
    }

    private fun errorMessage(request: Response<List<User>>) =
        Log.d(error, request.errorBody().toString())
}
