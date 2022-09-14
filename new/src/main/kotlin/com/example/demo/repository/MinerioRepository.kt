package com.example.demo.repository

import com.example.demo.model.Minerio
import org.springframework.data.jpa.repository.JpaRepository

interface MinerioRepository: JpaRepository<Minerio, Long> {
}