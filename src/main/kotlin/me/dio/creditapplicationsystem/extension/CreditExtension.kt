package me.dio.creditapplicationsystem.extension

import me.dio.creditapplicationsystem.dto.CreditDTO
import me.dio.creditapplicationsystem.dto.CreditView
import me.dio.creditapplicationsystem.dto.CreditViewList
import me.dio.creditapplicationsystem.model.Credit
import me.dio.creditapplicationsystem.model.Customer

fun CreditDTO.toCredit(): Credit{
    return Credit(
        creditValue = this.creditValue,
        dayFirstInstallment =  this.dayFirstInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )
}

fun Credit.toCreditViewList(): CreditViewList{
    return CreditViewList(
        this.creditCode,
        this.creditValue,
        this.numberOfInstallment
    )
}

fun Credit.toCreditView(): CreditView {
    return CreditView(
        this.creditCode,
        this.creditValue,
        this.numberOfInstallment,
        this.status,
        this.customer!!.email,
        this.customer!!.income

    )
}

