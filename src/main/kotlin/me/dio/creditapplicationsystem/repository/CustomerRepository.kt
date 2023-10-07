package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {
}