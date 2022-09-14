package com.example.demo.service

import com.example.demo.model.Area
import com.example.demo.repository.AreaRepository
import org.springframework.stereotype.Service

@Service
class AreaService (private val repository: AreaRepository) {

    fun buscarPorId(id: Long): Area {
        return repository.getOne(id)
    }


}
