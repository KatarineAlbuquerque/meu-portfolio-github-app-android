package me.dio.web.meuportfliogithub.data.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.dio.web.meuportfliogithub.api.GitHubApi
import me.dio.web.meuportfliogithub.data.repository.RepositoryUser
import me.dio.web.meuportfliogithub.data.usecase.UseCaseUser
import me.dio.web.meuportfliogithub.domain.User

class ViewModelUser() : ViewModel() {

    private var gitHubApi = GitHubApi()
    private var repository:RepositoryUser = RepositoryUser(gitHubApi)
    private var useCase: UseCaseUser = UseCaseUser(repository)
    private var list:List<User> = listOf()

    private var _repositories = MutableLiveData<List<User>>()

    private val repositoriesList: LiveData<List<User>>
        get() = _repositories

    companion object {
        const val error = "ERROR_EXCEPTION"
    }

    init {
        getAllRepositories()
    }

    fun getAllRepositories(): LiveData<List<User>> {
        Thread {
            try{
                list = repository.getRepositories()
                _repositories.postValue(useCase.invoke(list))
            } catch (exception: Exception) {
                errorMessage(exception)
            }
        }.start()
        return repositoriesList
    }

    private fun errorMessage(exception: Exception) {
        Log.d(error,exception.message.toString())
    }
}
