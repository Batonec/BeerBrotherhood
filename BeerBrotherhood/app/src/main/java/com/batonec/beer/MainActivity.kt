package com.batonec.beer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.batonec.beer.content.BeerNavigationBar
import com.batonec.beer.content.BeerNavigationTab
import com.batonec.beer.content.BeerNavigationTabSelector
import com.batonec.beer.ui.theme.BeerBrotherhoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            BeerBrotherhoodTheme {
                var selectedTab by remember { mutableStateOf(BeerNavigationTab.MARKET) }
                Scaffold(
                    content = { insets ->
                        insets.toString() // todo: respect insets
                        BeerNavigationTabSelector(selectedTab)
                    },
                    bottomBar = { BeerNavigationBar(selectedTab) { tab -> selectedTab = tab } }
                )
            }
        }
    }
}
