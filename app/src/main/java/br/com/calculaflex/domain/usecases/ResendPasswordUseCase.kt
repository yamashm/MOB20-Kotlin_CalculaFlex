package br.com.calculaflex.domain.usecases

import br.com.calculaflex.domain.entity.RequestState
import br.com.calculaflex.domain.repository.UserRepository

class ResendPasswordUseCase(
        private val userRepository: UserRepository
) {
    suspend fun resendPassword(email: String): RequestState<String> =
            userRepository.resendPassword(email)
}