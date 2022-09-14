package com.teste.extracao.model

import com.teste.extracao.model.Curso
import com.teste.extracao.model.Resposta
import com.teste.extracao.model.StatusTopico
import com.teste.extracao.model.Usuario
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topico(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
        val curso: Curso,
    @ManyToOne
        val autor: Usuario,
    @Enumerated(value = EnumType.STRING)
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    @OneToMany(mappedBy = "topico")
        val respostas: List<Resposta> = ArrayList()
)