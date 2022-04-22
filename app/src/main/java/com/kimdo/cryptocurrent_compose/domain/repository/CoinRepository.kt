package com.kimdo.cryptocurrent_compose.domain.repository

import com.kimdo.cryptocurrent_compose.data.remote.dto.CoinDetailDto
import com.kimdo.cryptocurrent_compose.data.remote.dto.CoinDto

interface CoinRepository {


    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}