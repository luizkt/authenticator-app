package br.com.lkt.authenticator.integration.feign.config

import br.com.lkt.authenticator.gateway.exception.BadRequestException
import br.com.lkt.authenticator.gateway.exception.NotFoundException
import feign.Response
import feign.codec.ErrorDecoder
import java.lang.Exception

class ErrorDecoder: ErrorDecoder {
    override fun decode(methodKey: String?, response: Response?): Exception {
        return when(response?.status()) {
            400 -> BadRequestException()
            404 -> NotFoundException()
            else -> Exception("Generic Error")
        }

    }
}