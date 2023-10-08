package me.dio.creditapplicationsystem.extension

import me.dio.creditapplicationsystem.dto.CustomerDTO
import me.dio.creditapplicationsystem.dto.CustomerUpdateDTO
import me.dio.creditapplicationsystem.dto.CustomerView
import me.dio.creditapplicationsystem.model.Adress
import me.dio.creditapplicationsystem.model.Customer

fun CustomerDTO.toCustomer(): Customer{
    return Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email =  this.email,
        income = this.income,
        password = this.password,
        address = Adress(zipCode,street)
    )
}
fun Customer.toCustomerDTO(): CustomerDTO{
    return CustomerDTO(
        this.firstName,
        this.lastName,
        this.cpf,
        this.income,
        this.email,
        this.password,
        this.address.street,
        this.address.zipCode
    )
}

fun Customer.toCustomerView(): CustomerView{
    return CustomerView(
        this.firstName,
        this.lastName,
        this.cpf,
        this.income,
        this.email,
        this.address.zipCode,
        this.address.street
    )
}

fun Customer.toCustomerUpdateDTO(customer: Customer): CustomerUpdateDTO{
    return CustomerUpdateDTO(
        customer.firstName,
        customer.lastName,
        customer.income,
        customer.address.zipCode,
        customer.address.street
    )
}

fun CustomerUpdateDTO.toCustomer(customer: Customer): Customer{
    return Customer(
        customer.id,
        this.firstName,
        this.lastName,
        customer.cpf,
        customer.email,
        this.income,
        customer.password,
        Adress(this.zipCode,this.street)
    )
}