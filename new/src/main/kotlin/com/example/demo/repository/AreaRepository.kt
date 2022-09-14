package com.example.demo.repository

import com.example.demo.model.Area
import org.springframework.data.jpa.repository.JpaRepository

interface AreaRepository: JpaRepository<Area, Long> {
}