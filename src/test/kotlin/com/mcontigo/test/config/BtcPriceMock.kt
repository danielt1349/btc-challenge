package com.mcontigo.test.config

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class BtcPriceMock(port: Int) : WireMockServer(port) {
    fun startMockServer() {
        start()

        stubFor(
            WireMock.get(WireMock.urlMatching("/v1/bpi/currentprice.json"))
                .willReturn(
                    WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(ClassPathResource("/mock/btc_price.json").file.readText())
                )
        )
    }
}
