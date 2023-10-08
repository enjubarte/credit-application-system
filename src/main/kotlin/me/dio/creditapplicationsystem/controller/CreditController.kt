package me.dio.creditapplicationsystem.controller

import jakarta.validation.Valid
import me.dio.creditapplicationsystem.dto.CreditDTO
import me.dio.creditapplicationsystem.dto.CreditView
import me.dio.creditapplicationsystem.dto.CreditViewList
import me.dio.creditapplicationsystem.extension.toCredit
import me.dio.creditapplicationsystem.extension.toCreditView
import me.dio.creditapplicationsystem.extension.toCreditViewList
import me.dio.creditapplicationsystem.service.Impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDTO: CreditDTO): ResponseEntity<String>{
        val credit = creditService.save(creditDTO.toCredit())
        return ResponseEntity(
            "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName}",
            HttpStatus.CREATED)
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>>{
        return ResponseEntity(
            creditService
                .findAllByCustomer(customerId)
                .map { c -> c.toCreditViewList() }
                .toList(),
            HttpStatus.OK)
    }

    @GetMapping("{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                         @PathVariable creditCode: UUID): ResponseEntity<CreditView>{
        return ResponseEntity(
            creditService
                .findByCreditCode(customerId,creditCode)
                .toCreditView(),
            HttpStatus.OK)
    }
}