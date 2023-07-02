package com.juliane.composetraining

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LowerPanel() {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Column {
        WeeklySpecial()
        MenuDish(count, { count++ }) { count-- }
    }
}

@Composable
fun WeeklySpecial() {

}

@Composable
fun MenuDish(count: Int, onIncrement: () -> Int, onDecrement: () -> Int) {
    Card(Modifier.clickable {
        onIncrement()
    }) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.fillMaxWidth(0.75f)) {
                Text(
                    text = "Greek Salad", fontSize = 18.sp, style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "The famous Greek salad of crispy lettuce, peppers, olives, our Chicago ...", color = Color.Gray, modifier = Modifier.padding(0.dp, 5.dp), fontSize = 18.sp, style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
                Row {
                    Text(
                        text = "$12.9", color = Color.Gray, style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp), text = "x $count", color = Color.Black, style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    AnimatedVisibility(visible = count > 0) {
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .clickable {
                                    onDecrement()
                                }, text = "(Remove Item)", color = Color.Black, style = TextStyle(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
            Column(
                Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_restau_banner), contentDescription = "Greek Salad Image", Modifier.clip(
                        RoundedCornerShape(10.dp)
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun LowerPanelPreview() {
    LowerPanel()
}