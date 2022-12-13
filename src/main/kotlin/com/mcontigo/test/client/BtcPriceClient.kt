package com.mcontigo.test.client

import com.mcontigo.test.model.BTCPriceDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

/*
Client Layer that expose external API communication of btc
*/
@FeignClient(name = "btc", url = "\${app.external.btc.url}")
interface BtcPriceClient {
    @GetMapping(
        "/v1/bpi/currentprice.json",
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun fetchCurrentPrice(): BTCPriceDto
}
