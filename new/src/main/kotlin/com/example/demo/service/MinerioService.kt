package com.example.demo.service

import com.example.demo.model.Minerio
import com.example.demo.repository.MinerioRepository
import org.springframework.stereotype.Service

@Service
class MinerioService(private val repository: MinerioRepository) {

    fun buscarPorId(id: Long): Minerio {
        return repository.getOne(id)
    }


}
