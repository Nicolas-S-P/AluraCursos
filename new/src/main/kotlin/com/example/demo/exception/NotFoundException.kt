package com.example.demo.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}