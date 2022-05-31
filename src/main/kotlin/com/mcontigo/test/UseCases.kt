package com.mcontigo.test

interface UseCases {
    fun fetchAll(): List<BTCPrice>
    fun fetchBtcPriceByFiat(type: FiatType): BTCPrice
    fun syncBtcPrice()
}