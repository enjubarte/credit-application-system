package me.dio.creditapplicationsystem.model

import jakarta.persistence.*
import me.dio.creditapplicationsystem.enums.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
@Entity
data class Credit(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false, unique = true)
    val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    val dayFirstInstallment: LocalDate,
    @Column(nullable = false)
    val numberOfInstallment: Int = 0,
    @Enumerated
    val status: Status = Status.IN_PROGRESS,
    @ManyToOne
    var customer: Customer? = null,
)
