package com.mcontigo.test.tasks

import com.mcontigo.test.service.UseCases
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/*
Task that perform the fetch btc price every 5 minutes from the external API
 */
@Component
class CronjobBtc {
    companion object {
        private const val EVERY_ONE = "0 */1 * ? * *"
        private const val EVERY_FIVE = "0 */5 * ? * *"
    }

    private val logger = LoggerFactory.getLogger(CronjobBtc::class.java)

    @Autowired
    private lateinit var btcService: UseCases

    @Scheduled(cron = EVERY_FIVE)
    fun fetchBtc() {
        logger.info("--CronjobBtc:fetchBtc-- CRON JOB START |m| --")
        btcService.syncBtcPrice()
        logger.info("--CronjobBtc:fetchBtc-- CRON JOB END |m| --")
    }
}
