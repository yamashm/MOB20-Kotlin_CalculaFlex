package br.com.calculaflex.domain.entity

data class NewUser(
        val name: String,
        val email: String,
        val phone: String,
        val password: String
)