package me.dio.creditapplicationsystem.service.Impl

import me.dio.creditapplicationsystem.model.Credit
import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val repository: CreditRepository,
    private val customerService: CustomerService

): ICreditService {
    override fun save(credit: Credit): Credit{
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return repository.save(credit)
    }


    override fun findAllByCustomer(customerId: Long): List<Credit> =
        customerService.findById(customerId).credits

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit =
        repository.findByCreditCodeAndCustomerId(creditCode,customerId)
}