package com.example.demo.model

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Solicitacao(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val titulo: String,
        val dataSolicitacao: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val extracao: Extracao
)
