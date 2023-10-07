package me.dio.creditapplicationsystem.model

import jakarta.persistence.*

@Entity
data class Customer(
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    var firstName: String = "",
    @Column(nullable = false)
    var lastName: String = "",
    @Column(nullable = false, unique = true)
    val cpf: String,
    @Column(nullable = false, unique = true)
    var email: String = "",
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