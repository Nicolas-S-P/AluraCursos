package com.teste.extracao.service

import com.teste.extracao.model.Usuario
import com.teste.extracao.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }


}
