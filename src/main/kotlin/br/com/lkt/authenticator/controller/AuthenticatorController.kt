package br.com.lkt.authenticator.controller

import br.com.lkt.authenticator.domain.entity.student.response.StudentResponse
import br.com.lkt.authenticator.usecase.FindStudentUseCase
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(produces = [(MediaType.APPLICATION_JSON_VALUE)])
@Api("Execute authentication")
class AuthenticatorController(
        val findStudentUseCase: FindStudentUseCase
) {

    @RequestMapping(path = ["/students/{studentRegistrationNumber}"], method = [RequestMethod.GET], produces = ["application/json"])
    @ResponseBody
    @ApiOperation(value = "Get the studnet")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Get the student"),
        ApiResponse(code = 400, message = "Some field have wrong information"),
        ApiResponse(code = 500, message = "Some error occurred")
    ])
    fun findByStudentRegistrationNumber(@PathVariable studentRegistrationNumber: String): ResponseEntity<StudentResponse> {
        val student = findStudentUseCase.execute(studentRegistrationNumber)

        return ResponseEntity(student, HttpStatus.OK)
    }

}