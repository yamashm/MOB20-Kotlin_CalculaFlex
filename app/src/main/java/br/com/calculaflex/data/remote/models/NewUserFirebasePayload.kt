package br.com.calculaflex.data.remote.models

import com.google.firebase.firestore.Exclude

data class NewUserFirebasePayload(
    val name: String? = null,
    val email: String? = null,
    val phone: String? = null,
    @get: Exclude val password: String? = null //Não vai salvar no banco
)