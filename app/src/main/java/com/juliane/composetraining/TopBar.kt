package com.juliane.composetraining

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(onClick = {
            scope.launch {
                scaffoldState.drawerState.open()
            }
        }) {
            Icon(
                painterResource(
                    id = R.drawable.ic_menu
                ),
                contentDescription = "Menu icon",
                Modifier.size(24.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Mini logo",
                Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "QuickBites",
                color = Color(0xFFFF781F),
                fontSize = 22.sp,
                fontFamily = FontFamily.Cursive
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painterResource(
                    id = R.drawable.ic_cart
                ),
                contentDescription = "Cart icon",
                Modifier
                    .size(24.dp)
            )
        }
    }
}