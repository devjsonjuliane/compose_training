package com.juliane.composetraining

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UpperPanel() {
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(id = R.string.app_name), fontSize = 30.sp,
            color = Color(0xFFFF781F)
        )
        Text(
            text = stringResource(R.string.text_branch), fontSize = 16.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(0.dp, 7.5.dp, 0.dp, 7.5.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 7.5.dp, 0.dp, 7.5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.app_description),
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp,
                modifier = Modifier.width(250.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.img_restau_banner),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
                    .padding(3.5.dp, 5.dp)
                    .clip(RoundedCornerShape(25.dp))
            )
        }
        Button(
            onClick = {
                Toast.makeText(context, "Order received. Thank you!", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFFF781F)),
            modifier = Modifier.padding(0.dp, 7.5.dp, 0.dp, 7.5.dp)
        ) {
            Text(
                text = stringResource(R.string.text_order),
                color = Color(0xFFFFFFFF)
            )
        }
    }
}

@Preview
@Composable
fun UpperPanelPreview() {
    UpperPanel()
}