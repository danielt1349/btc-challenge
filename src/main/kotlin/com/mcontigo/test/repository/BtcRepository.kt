package com.mcontigo.test.repository

import com.mcontigo.test.enums.FiatType
import com.mcontigo.test.model.BTCPrice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BtcRepository : JpaRepository<BTCPrice, UUID>, JpaSpecificationExecutor<BTCPrice> {
    fun findAllByFiatTypeOrderByRegisterAtDesc(fiatType: FiatType): List<BTCPrice>
}
