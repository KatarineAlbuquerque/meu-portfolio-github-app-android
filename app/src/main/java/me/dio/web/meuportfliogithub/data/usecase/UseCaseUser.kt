package me.dio.web.meuportfliogithub.data.usecase

import me.dio.web.meuportfliogithub.data.repository.RepositoryUser
import me.dio.web.meuportfliogithub.domain.User

class UseCaseUser(private val repositoryUser: RepositoryUser) {

    fun invoke(list:List<User>):List<User> {
        return list
    }
}