package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import me.dio.creditapplicationsystem.enums.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    @field:Min(1)
    @field:Max(48)
    val numberOfInstallment: Int,
    val status: Status,
    val emailCustomer: String,
    val incomeCustomer: BigDecimal
)
