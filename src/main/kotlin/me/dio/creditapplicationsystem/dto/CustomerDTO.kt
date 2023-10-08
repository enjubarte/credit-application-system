package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO(
    @field:NotEmpty(message = "Invalid Input")
    val firstName: String,
    @field:NotEmpty(message = "Invalid Input")
    val lastName: String,
    @field:NotEmpty(message = "Invalid Input")
    @field: CPF(message = "This invalid CPF")
    val cpf: String,
    @field: NotNull(message = "Invalid Input")
    val income: BigDecimal,
    @field:NotEmpty(message = "Invalid Input")
    val email: String,
    @field:NotEmpty(message = "Invalid Input")
    val password: String,
    @field:NotEmpty(message = "Invalid Input")
    val zipCode: String,
    @field:NotEmpty(message = "Invalid Input")
    val street: String
)
