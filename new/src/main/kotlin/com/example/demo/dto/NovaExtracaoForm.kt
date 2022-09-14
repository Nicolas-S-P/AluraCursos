package com.example.demo.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovaExtracaoForm(
        @field:NotEmpty(message = "Titulo nao pode ser em branco")
        @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres")
        val titulo: String,
        @field:NotEmpty(message = "Mensagem nao pode ser em branco")
        val descricao: String,
        @field:NotNull
        val idMinerio: Long,
        @field:NotNull
        val idArea: Long
)
