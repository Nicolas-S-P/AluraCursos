package com.teste.extracao.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}