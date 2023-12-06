package com.batonec.beer.content.market

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.batonec.beer.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketScreen() {
    Column(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TopAppBar(title = { Text(text = "Market") })
        MarketList()
    }
}

@Composable
private fun MarketList() {
    val marketItems = remember { listOf(Bets, Actions) }
    LazyColumn {
        items(
            marketItems,
            key = { item -> item.id },
            itemContent = { item ->
                when (item) {
                    is Bets -> Bet()
                    is Actions -> Actions()
                }
            }
        )
    }
}

@Suppress("MagicNumber")
@Composable
private fun Bet() {
    Card(
        Modifier.padding(horizontal = 16.dp)
    ) {
        Image(
            modifier = Modifier
                .aspectRatio(16 / 9f)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium),
            painter = painterResource(R.drawable.gamble),
            contentDescription = "gamble",
        )

        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 4.dp),
            text = "Participate in bet event!",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Annual salary gambling is already here!"
        )
        Button(
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 16.dp),
            onClick = { }
        ) { Text(text = "Buy tickets") }
    }
}

@Composable
private fun Actions() {
    Column(
        modifier = Modifier.padding(
            start = 16.dp, end = 16.dp, top = 16.dp,
        )
    ) {
        Text(
//            modifier = Modifier.padding(bottom = 8.dp),
            text = "Spend your BeerPoints here!",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )

        ActionItem(
            "Scram mastery!",
            "Don't want to manage daily meetings?)"
        )

        ActionItem(
            "Extra release master!",
            "Lets have your colleague helping release to be released"
        )

        ActionItem(
            "PR review!",
            "In the case you're not in the mood to make a review",
            divider = false
        )
    }
}

@Composable
private fun ActionItem(
    title: String,
    subtitle: String,
    divider: Boolean = true
) {
    Column {
        Row(Modifier.padding(top = 16.dp)) {
            Column(
                modifier = Modifier.weight(1f),
            ) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = "Buy"
            )
        }
        if (divider) {
            Divider(
                modifier = Modifier.padding(top = 16.dp),
            )
        }
    }
}