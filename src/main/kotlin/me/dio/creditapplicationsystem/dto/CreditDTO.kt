package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    @field:NotNull(message = "Invalid Input")
    val creditValue: BigDecimal,
    @field: Future
    val dayFirstInstallment: LocalDate,
    @field: Size(min = 1, max = 38)
    val numberOfInstallment: Int,
    @field:NotNull(message = "Invalid Input")
    val customerId: Long
)
