package com.mcontigo.test.service

import com.mcontigo.test.enums.FiatType
import com.mcontigo.test.model.BTCPrice

/*
Interface to handle the uses cases
*/
interface UseCases {
    fun fetchAll(): List<HashMap<String, BTCPrice>>
    fun fetchBtcPriceByFiat(type: FiatType): List<HashMap<String, BTCPrice>>
    fun syncBtcPrice()
}
