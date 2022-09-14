package com.teste.extracao.service

import com.teste.extracao.model.Curso
import com.teste.extracao.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getOne(id)
    }


}
