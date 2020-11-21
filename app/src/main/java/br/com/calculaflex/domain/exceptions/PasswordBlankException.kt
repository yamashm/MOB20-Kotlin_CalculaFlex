package br.com.calculaflex.domain.exceptions

import java.lang.Exception

class PasswordBlankException: Exception("Senha não pode estar em branco")