package me.dio.creditapplicationsystem.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Customer(
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    var firstName: String = "",
    @Column(nullable = false)
    var lastName: String = "",
    @Column(nullable = false, unique = true)
    var cpf: String = "",
    @Column(nullable = false, unique = true)
    var email: String = "",
    @Column(nullable = false)
    val income: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    var password: String = "",
    @Column(nullable = false)
    @Embedded
    var address: Adress = Adress(),
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE],
    mappedBy = "customer"
    )
    var credits: List<Credit> = mutableListOf()
)
