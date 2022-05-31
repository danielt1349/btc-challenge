package com.mcontigo.test

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("btc")
class BTCController { /*
    You should implement all resources of API requests here
    GET:
        / - retrieve all btc fiat pairs registered ordered by date
        /pair/:fiatType - retrieve current value of pair BTC-fiatType
    POST:
        / - execute a task to fetch btc price and persist on database
     */
}