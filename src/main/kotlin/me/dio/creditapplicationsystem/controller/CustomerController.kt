package me.dio.creditapplicationsystem.controller

import jakarta.validation.Valid
import me.dio.creditapplicationsystem.dto.CustomerDTO
import me.dio.creditapplicationsystem.dto.CustomerView
import me.dio.creditapplicationsystem.extension.toCustomer
import me.dio.creditapplicationsystem.extension.toCustomerUpdateDTO
import me.dio.creditapplicationsystem.extension.toCustomerView
import me.dio.creditapplicationsystem.service.Impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDTO: CustomerDTO): ResponseEntity<String> {
        val save = customerService.save(customerDTO.toCustomer())
        return ResponseEntity("Customer ${save.email} saved", HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView>
        = ResponseEntity(
            customerService.findById(id).toCustomerView(),
            HttpStatus.OK
        )


    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody @Valid customerDTO: CustomerDTO): CustomerView{
        val customer = customerService.findById(id).toCustomerUpdateDTO(customerDTO.toCustomer()).toCustomer(customerDTO.toCustomer())
        customerService.save(customer)
        return customer.toCustomerView()
    }
}