package br.com.lkt.authenticator.usecase

import br.com.lkt.authenticator.domain.entity.student.response.StudentResponse
import br.com.lkt.authenticator.gateway.StudentGateway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class FindStudentUseCase(
        val studentGateway: StudentGateway
) {

    private val logger: Logger = LoggerFactory.getLogger(StudentGateway::class.java)
    private val ruleName = "[Student] [UseCase]"

    fun execute(studentRegistrationNumber: String): StudentResponse {
        logger.info("$ruleName Start process to get student by registration number")
        val student = studentGateway.getStudentByRegistrationNumber(studentRegistrationNumber)
        logger.info("$ruleName [SUCCESS] Get student successfully")

        return student
    }
}