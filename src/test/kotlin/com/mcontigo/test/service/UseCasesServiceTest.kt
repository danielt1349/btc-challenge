package com.mcontigo.test.service

import com.mcontigo.test.config.BtcPriceMock
import com.mcontigo.test.enums.FiatType
import com.mcontigo.test.repository.BtcRepository
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UseCasesServiceTest {

    private var btcPriceMock = BtcPriceMock(8090)

    @Autowired
    private lateinit var useCases: UseCases

    @Autowired
    private lateinit var repository: BtcRepository

    @BeforeAll
    fun loadMock() {
        btcPriceMock.startMockServer()
    }

    @AfterAll
    fun shutDownMock() {
        btcPriceMock.stop()
    }

    @Test
    fun syncBtcPrice() {
        useCases.syncBtcPrice()

        repository.findAllByFiatTypeOrderByRegisterAtDesc(FiatType.USD).let {
            Assertions.assertTrue(it[0].fiatType.toString() == "USD")
            Assertions.assertTrue(it.size == 1)
        }
    }
}
