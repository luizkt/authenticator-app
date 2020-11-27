package br.com.lkt.authenticator.gateway.exception

class NotFoundException: RuntimeException() {

//    fun NotFoundException() {}
//
//    fun NotFoundException(message: String?) {
//        super(message)
//    }
//
//    fun NotFoundException(cause: Throwable?) {
//        super(cause)
//    }

    override fun toString(): String {
        return "NotFoundException: $message"
    }
}