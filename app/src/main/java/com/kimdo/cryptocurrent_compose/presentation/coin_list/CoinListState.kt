package com.kimdo.cryptocurrent_compose.presentation.coin_list

import com.kimdo.cryptocurrent_compose.domain.model.Coin

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)