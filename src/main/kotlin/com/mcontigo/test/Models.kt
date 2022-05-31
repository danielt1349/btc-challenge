package com.mcontigo.test

import java.math.BigDecimal
import java.time.LocalDateTime

data class BTCPrice (
    val price: BigDecimal,
    val lastUpdate: LocalDateTime,
    val fiatType: FiatType
)

enum class FiatType {
    USD, GBP, EUR
}
