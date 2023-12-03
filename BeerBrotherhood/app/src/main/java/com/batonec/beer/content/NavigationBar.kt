package com.batonec.beer.content

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.batonec.beer.content.BeerNavigationTab.HOME
import com.batonec.beer.content.BeerNavigationTab.MARKET
import com.batonec.beer.content.BeerNavigationTab.PROFILE
import com.batonec.beer.content.market.MarketScreen

enum class BeerNavigationTab { HOME, MARKET, PROFILE }

@Composable
fun BeerNavigationBar(
    selectedNavigationTab: BeerNavigationTab,
    tabSelected: (BeerNavigationTab) -> Unit
) {
    NavigationBar {
        BeerNavigationBarItem(
            selected = selectedNavigationTab == HOME,
            onClick = { tabSelected(HOME) },
            iconId = Icons.Default.Home,
            title = "Home"
        )

        BeerNavigationBarItem(
            selected = selectedNavigationTab == MARKET,
            onClick = { tabSelected(MARKET) },
            iconId = Icons.Default.ShoppingCart,
            title = "Market"
        )

        BeerNavigationBarItem(
            selected = selectedNavigationTab == PROFILE,
            onClick = { tabSelected(PROFILE) },
            iconId = Icons.Default.Person,
            title = "Profile"
        )
    }
}
@Composable
private fun RowScope.BeerNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    title: String,
    iconId: ImageVector
) {

    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = iconId,
                contentDescription = title
            )
        },
        label = { Text(text = title) },
        alwaysShowLabel = true,
    )
}

@Composable
fun BeerNavigationTabSelector(currentTab: BeerNavigationTab) {
    when (currentTab) {
        HOME -> HomeScreen()
        MARKET -> MarketScreen()
        PROFILE -> ProfileScreen()
    }
}