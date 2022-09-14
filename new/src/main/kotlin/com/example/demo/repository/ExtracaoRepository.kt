package com.example.demo.repository

import com.example.demo.dto.ExtracaoPorNomeDto
import com.example.demo.model.Extracao
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ExtracaoRepository: JpaRepository<Extracao, Long> {

    fun findByMinerioNome(nomeMinerio: String, paginacao: Pageable): Page<Extracao>

    @Query("SELECT new com.example.demo.dto.ExtracaoPorNomeDto(minerio.nome,count(t)) FROM Extracao t JOIN t.minerio minerio GROUP BY minerio.nome")
    fun relatorio(): List<ExtracaoPorNomeDto>

}