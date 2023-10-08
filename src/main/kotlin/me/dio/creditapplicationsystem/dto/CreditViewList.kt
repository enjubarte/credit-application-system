package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    @field:Min(1)
    @field:Max(48)
    val numberOfInstallment: Int
)
