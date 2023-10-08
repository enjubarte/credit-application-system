package me.dio.creditapplicationsystem.dto


import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDTO(
    @field:NotEmpty(message = "Invalid Input")
    val firstName: String,
    @field:NotEmpty(message = "Invalid Input")
    val lastName: String,
    @field: NotNull(message = "Invalid Input")
    val income: BigDecimal,
    @field:NotEmpty(message = "Invalid Input")
    val zipCode: String,
    @field:NotEmpty(message = "Invalid Input")
    val street: String
)
