package br.com.lkt.authenticator.gateway

import br.com.lkt.authenticator.domain.entity.student.response.StudentResponse
import br.com.lkt.authenticator.integration.client.StudentClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class StudentGateway(
        private val studentClient: StudentClient
) {

    private val logger: Logger = LoggerFactory.getLogger(StudentGateway::class.java)
    private val ruleName = "[Student] [Gateway]"

    fun getStudentByRegistrationNumber(studentRegistrationNumber: String): StudentResponse {
        logger.info("$ruleName Requesting student endpoint")
        val student = studentClient.getStudentByRegistrationNumber(studentRegistrationNumber)
        logger.info("$ruleName Student found successfully")
        return student
    }

}