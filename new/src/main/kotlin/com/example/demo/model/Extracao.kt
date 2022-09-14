package com.example.demo.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Extracao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var titulo: String,
    var descricao: String,
    val dataSolicitacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val minerio: Minerio,
    @ManyToOne
    val area: Area,
    @Enumerated(value = EnumType.STRING)
    val status: StatusExtracao = StatusExtracao.SOLICITADA,
    @OneToMany(mappedBy = "extracao")
    val solicitacao: List<Solicitacao> = ArrayList()
)