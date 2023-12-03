package com.batonec.beer.content.market

sealed class MarketItem {

    val id: String get() = hashCode().toString()
}

data object Bets : MarketItem()
data object Actions : MarketItem()