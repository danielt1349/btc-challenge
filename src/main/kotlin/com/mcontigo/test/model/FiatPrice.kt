package com.mcontigo.test.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.mcontigo.test.enums.FiatType
import java.math.BigDecimal

class FiatPrice {
    var code: FiatType? = null
    var symbol: String? = null
    var rate: String? = null
    var description: String? = null
    @JsonProperty("rate_float")
    var rateFloat: BigDecimal? = null
}
