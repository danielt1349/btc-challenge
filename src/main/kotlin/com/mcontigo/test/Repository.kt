package com.mcontigo.test

import java.math.BigDecimal
import java.time.LocalDateTime

/*
You should implement this interface to interact with persistence
If you prefer, can use any ORM library
*/
internal interface RepositoryDB {
    fun fetchAll(): List<BTCPrice>
    fun fetchByFiat(fiatType: FiatType): BTCPrice
    fun registerBTCPrice(price: BigDecimal, registerAt: LocalDateTime)
}

/*
 You should implement this based on coindesk request from https://api.coindesk.com/v1/bpi/currentprice.json
 */
internal interface RepositoryExternal {
    fun fetchCurrentPrice(): List<BTCPrice>
}