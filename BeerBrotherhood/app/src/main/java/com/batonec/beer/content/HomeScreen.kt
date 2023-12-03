package com.batonec.beer.content

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.batonec.beer.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TopAppBar(title = { Text(text = "Home") })
        WelcomeCard()
        LadderCard()
    }
}

@Composable
private fun WelcomeCard() {
    Card(Modifier.wrapContentHeight()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Titles()
            BeerCounter()
        }
    }
}

@Composable
private fun RowScope.Titles() {
    Column(Modifier.weight(1f)) {
        Text(
            style = MaterialTheme.typography.headlineSmall,
            text = "Hello, beerHunter!"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = "Today is Tuesday, and you've successfully owned 100 beers!"
        )
    }
}

@Composable
private fun BeerCounter() {
    val height = 120.dp // todo allocations? value class?
    val textMeasurer = rememberTextMeasurer()

    val textToDraw = "46"

    val style = MaterialTheme.typography.headlineLarge.copy(
        fontSize = 50.sp, color = MaterialTheme.colorScheme.onSurface
    )

    // Keys are to demonstrate that you can re-calculate block inside
    // when any of them change. Otherwise remember results on each recomposition
    val textLayoutResult = remember(textToDraw, style) {
        textMeasurer.measure(textToDraw, style)
    }

    Canvas(
        modifier = Modifier
            .size(height)
    ) {
        drawArc(
            brush = Brush.horizontalGradient(
                listOf(Color(0xffFD7D20), Color(0xffFBE41A))
            ),
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = true,
            style = Stroke(
                width = 4.dp.toPx()
            )
        )
        drawText(
            textMeasurer = textMeasurer,
            text = textToDraw,
            style = style,
            topLeft = Offset(
                x = center.x - textLayoutResult.size.width / 2,
                y = center.y - textLayoutResult.size.height / 2,
            )
        )
    }
}

@Composable
private fun LadderCard() {
    Card {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.padding(16.dp)
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Ladder",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "BeerLord (top 1498)",
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically),
                imageVector = ImageVector.vectorResource(R.drawable.rank),
                contentDescription = "Rank"
            )
        }

    }
}