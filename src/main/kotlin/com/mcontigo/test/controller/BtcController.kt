package com.mcontigo.test.controller

import com.mcontigo.test.enums.FiatType
import com.mcontigo.test.model.BTCPrice
import com.mcontigo.test.service.UseCases
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/btc")
@Api(tags = ["btc.price"])
class BtcController(
    private val useCases: UseCases
) {

/*
API to get all List of btc pairs and order by registeredAt desc
*/
    @GetMapping("/get-all")
    fun index(): List<HashMap<String, BTCPrice>> {
        return useCases.fetchAll()
    }
/*
API to get all List of btc pairs filtered by fiatType and order by registeredAt desc
*/
    @GetMapping("/pair/{fiatType}")
    fun show(@PathVariable fiatType: FiatType): List<HashMap<String, BTCPrice>> {
        return useCases.fetchBtcPriceByFiat(fiatType)
    }
}
