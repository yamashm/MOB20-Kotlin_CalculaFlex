package br.com.calculaflex.domain.repository

import br.com.calculaflex.domain.entity.NewUser
import br.com.calculaflex.domain.entity.RequestState
import br.com.calculaflex.domain.entity.User
import br.com.calculaflex.domain.entity.UserLogin

interface UserRepository {
        suspend fun getUserLogged(): RequestState<User>

        suspend fun doLogin(userLogin: UserLogin): RequestState<User>

        suspend fun resendPassword(email: String): RequestState<String>

        suspend fun create(newUser: NewUser): RequestState<User>
}