package com.juliane.composetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juliane.composetraining.R

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Container()
        }
    }
}

@Composable
fun Container() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(300.dp)
                .height(150.dp),
            painter = painterResource(id = R.drawable.img_logo),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(15.dp))
        TextField(
            value = stringResource(R.string.hint_username),
            onValueChange = {}
        )
        Spacer(modifier = Modifier.size(15.dp))
        TextField(
            value = stringResource(R.string.hint_password),
            onValueChange = {}
        )
        Spacer(modifier = Modifier.size(15.dp))
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF781F)),
            shape = RoundedCornerShape(5.dp),
            onClick = { /*TODO*/ },
        ) {
            Text(text = stringResource(R.string.text_login), color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Container()
}