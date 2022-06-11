package com.example.tasbeh

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasbeh.ui.theme.TasbehTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasbehTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    TasbehScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun TasbehScreen() {
    var count: Int by remember { mutableStateOf(0) }
    val activity = (LocalContext.current as? Activity)
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            modifier = Modifier
                .padding()
                .fillMaxWidth(), backgroundColor = Color.White
        ) {
            Text(text = "Tasbeh", color = Color.Black, textAlign = TextAlign.Center, fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(start = 16.dp))
        }
    }) {
        Column() {
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },) {
                    count++


                }, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = count.toString(), fontSize = 32.sp, textAlign = TextAlign.Center, modifier = Modifier
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                MyButton(
                    title = "Finish", modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp)
                ) {
                    activity?.finish()
                }
                MyButton(
                    title = "Restart", modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp)
                ) {
                    count = 0
                }

            }
        }
    }
}

@Composable
fun MyButton(title: String, modifier: Modifier, clickable: () -> Unit) {
    Button(
        onClick = {
            clickable()
        },
        modifier = modifier
    ) {
        Text(text = title, textAlign = TextAlign.Center)
    }
}
