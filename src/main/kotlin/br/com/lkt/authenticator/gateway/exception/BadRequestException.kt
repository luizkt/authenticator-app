package br.com.lkt.authenticator.gateway.exception

import java.lang.RuntimeException

class BadRequestException: RuntimeException() {

//    fun BadRequestException() {}
//
//    fun BadRequestException(message: String?) {
//        message = message
//    }
//
//    fun BadRequestException(cause: Throwable?) {
//        super(cause)
//    }

    override fun toString(): String {
        return "BadRequestException: $message"
    }
}