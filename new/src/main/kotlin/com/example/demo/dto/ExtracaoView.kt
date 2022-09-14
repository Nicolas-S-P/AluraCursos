package com.example.demo.dto

import com.example.demo.model.StatusExtracao
import com.example.demo.model.Extracao
import java.time.LocalDateTime

data class ExtracaoView(
        val id: Long?,
        val titulo: String,
        val descricao: String,
        val status: StatusExtracao,
        val dataSolicitacao: LocalDateTime
)
