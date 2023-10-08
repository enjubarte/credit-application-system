package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
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
    @field:Min(1)
    @field:Max(48)
    val numberOfInstallment: Int,
    @field:NotNull(message = "Invalid Input")
    val customerId: Long
)
