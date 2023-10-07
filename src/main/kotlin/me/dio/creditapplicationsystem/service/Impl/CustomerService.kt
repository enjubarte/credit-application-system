package me.dio.creditapplicationsystem.service.Impl

import me.dio.creditapplicationsystem.model.Customer
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val repository: CustomerRepository): ICustomerService{
    override fun save(customer: Customer): Customer =
        repository.save(customer)

    override fun findById(id: Long): Customer =
        repository.findById(id).orElseThrow{
            throw RuntimeException("ID $id NOT FOUND")
        }

    override fun delete(id: Long) = repository.deleteById(id)

}