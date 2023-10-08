package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.enums.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int,
    val status: Status,
    val emailCustomer: String,
    val incomeCustomer: BigDecimal
)
