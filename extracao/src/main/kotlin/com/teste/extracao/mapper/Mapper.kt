package com.teste.extracao.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
