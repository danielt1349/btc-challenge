package com.mcontigo.test.model

import com.mcontigo.test.enums.FiatType
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "btc")
class BTCPrice(
    @Id
    @Column(updatable = false, nullable = false)
    var uuid: UUID = UUID.randomUUID(),
    @Column
    var price: BigDecimal? = null,
    @Column(name = "fiat_type")
    @Enumerated(EnumType.STRING)
    var fiatType: FiatType? = null,
    @Column(name = "last_update")
    var lastUpdate: LocalDateTime? = null,
    @Column(name = "register_at")
    var registerAt: LocalDateTime? = LocalDateTime.now(),
)
