package br.com.lkt.authenticator.domain.entity.student.response

data class StudentResponse(
    val message: String,
    val data: Data
) {
    data class Data(
        val studentRegistrationNumber: Int,
        val name: String
    )
}