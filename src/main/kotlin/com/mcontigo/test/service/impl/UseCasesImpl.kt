package com.mcontigo.test.service.impl

import com.mcontigo.test.client.BtcPriceClient
import com.mcontigo.test.enums.FiatType
import com.mcontigo.test.model.BTCPrice
import com.mcontigo.test.repository.BtcRepository
import com.mcontigo.test.service.UseCases
import com.mcontigo.test.utils.DateUtil
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

/*
Service Layer that performs the business logic of btc
*/
@Service
class UseCasesImpl(
    private val btcPriceClient: BtcPriceClient,
    private val btcRepository: BtcRepository
) : UseCases {

    private val logger = LoggerFactory.getLogger(UseCasesImpl::class.java)

    private fun buildPairBtc(btcAll: List<BTCPrice>): List<HashMap<String, BTCPrice>> {
        val listBtc = mutableListOf<HashMap<String, BTCPrice>>()
        btcAll.forEach {
            val pairBtc = HashMap<String, BTCPrice>()
            pairBtc[it.fiatType.toString()] = it
            listBtc.add(pairBtc)
        }
        return listBtc
    }

    override fun fetchAll(): List<HashMap<String, BTCPrice>> {
        val btcAll = btcRepository.findAll(Sort.by(Sort.Direction.DESC, "registerAt"))
        return buildPairBtc(btcAll)
    }

    override fun fetchBtcPriceByFiat(type: FiatType): List<HashMap<String, BTCPrice>> {
        val btcPriceByFiat = btcRepository.findAllByFiatTypeOrderByRegisterAtDesc(type)
        return buildPairBtc(btcPriceByFiat)
    }

    override fun syncBtcPrice() {
        try {
            logger.info("syncBtcPrice from btcPriceClient")
            val btcPrice = btcPriceClient.fetchCurrentPrice()
            btcPrice.bpi.forEach {
                val btc = BTCPrice().apply {
                    fiatType = it.value.code
                    price = it.value.rateFloat
                    lastUpdate = btcPrice.time?.updated?.let { updated ->
                        DateUtil.getCurrentDateTimeWithTulFormat(updated)
                    }
                }
                logger.info("syncBtcPrice from btcPriceClient::save")
                btcRepository.save(btc)
            }
        } catch (e: Exception) {
            logger.info("syncBtcPrice from btcPriceClient::Error ${e.message}")
        }
    }
}
