package com.mcontigo.test.controller

import com.mcontigo.test.enums.FiatType
import com.mcontigo.test.model.BTCPrice
import com.mcontigo.test.repository.BtcRepository
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDateTime

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BtcControllerTest {

    @Autowired
    private lateinit var repository: BtcRepository

    @Autowired
    private lateinit var mockMvc: MockMvc

    private fun createBtc(btcType: String) = repository.save(
        BTCPrice().apply {
            price = 17175.35.toBigDecimal()
            fiatType = FiatType.valueOf(btcType)
            lastUpdate = LocalDateTime.now()
        }
    )

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    fun index() {
        val btcTypes = listOf("USD", "GBP", "EUR")

        for (i in btcTypes.indices) {
            createBtc(btcTypes[i])
        }

        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/btc/get-all"))
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(
                MockMvcResultMatchers.status().isOk,
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                MockMvcResultMatchers.jsonPath("$[0].EUR.fiat_type", Matchers.equalTo("EUR")),
                MockMvcResultMatchers.jsonPath("$[0].EUR.price", Matchers.equalTo(17175.35)),
                MockMvcResultMatchers.jsonPath("$.length()", Matchers.equalTo(3))
            )
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    fun show() {
        val btcTypes = listOf("USD", "GBP", "EUR")

        for (i in btcTypes.indices) {
            createBtc(btcTypes[i])
        }

        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/btc/pair/EUR"))
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(
                MockMvcResultMatchers.status().isOk,
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                MockMvcResultMatchers.jsonPath("$[0].EUR.fiat_type", Matchers.equalTo("EUR")),
                MockMvcResultMatchers.jsonPath("$[0].EUR.price", Matchers.equalTo(17175.35)),
                MockMvcResultMatchers.jsonPath("$.length()", Matchers.equalTo(1))
            )
    }
}
