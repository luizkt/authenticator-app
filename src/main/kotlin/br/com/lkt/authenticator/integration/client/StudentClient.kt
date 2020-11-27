package br.com.lkt.authenticator.integration.client

import br.com.lkt.authenticator.domain.entity.student.response.StudentResponse
import br.com.lkt.authenticator.integration.feign.config.FeignConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "student", url = "\${url.student}",
    configuration = [FeignConfig::class]
)
interface StudentClient {
    @GetMapping(value = ["/processor-app/api/students/{studentRegistrationNumber}"])
    fun getStudentByRegistrationNumber(@PathVariable studentRegistrationNumber: String): StudentResponse
}