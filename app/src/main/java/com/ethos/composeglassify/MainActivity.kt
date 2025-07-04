package com.ethos.composeglassify

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ethos.composeglassify.ui.theme.ComposeGlassifyTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeGlassifyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    MainScreen()
//                    DemoGlassCard()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeGlassifyTheme {
//        Greeting("Android")
//    }
//}
@RequiresApi(Build.VERSION_CODES.S)

@Composable
fun MainScreen(modifier: Modifier =Modifier){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Image(painter = painterResource(R.drawable.ios_stock_1_for_iphone_x), contentDescription = "background Image",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)

        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center) {
//            GlassCard2New(content = {
//                Text("Glass Card")
//                Image(painter = painterResource(R.drawable.peacock_feather_img), contentDescription = "background Image",
//                    modifier = Modifier.size(150.dp), contentScale = ContentScale.Crop)
//            }

//            )



            LiquidGlass27 (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Hello Glass!", color = Color.White)
                    Image(painter = painterResource(id = R.drawable.event_img
                    ), contentDescription = null)

                    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Green),onClick = { /*TODO*/ }) {
                            Text("Save")
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Gray),
                            onClick = { /*TODO*/ }) {
                            Text("Cancel")
                        }
                    }

                }
            )

            LiquidGlass26 (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Hello Glass!", color = Color.White)
                    Text("Hello some random words chacklcjd Glass!", color = Color.White)
                    Text("Hello jkdc cjejckc omdn Glass!", color = Color.White)
                    Text("someyh hHello Gsgfsflass!", color = Color.White)
//                    Image(painter = painterResource(id = R.drawable.event_img
//                    ), contentDescription = null)

                    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly) {
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Green),onClick = { /*TODO*/ }) {
                            Text("Save")
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Gray),
                            onClick = { /*TODO*/ }) {
                            Text("Cancel")
                        }
                    }

                }
            )
            LiquidGlass28 (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Hello Glass!", color = Color.White)
                    Image(painter = painterResource(id = R.drawable.event_img
                    ), contentDescription = null)

                    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Green),onClick = { /*TODO*/ }) {
                            Text("Save")
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Gray),
                            onClick = { /*TODO*/ }) {
                            Text("Cancel")
                        }
                    }

                }
            )

            LiquidGlass29 (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Hello Glass!", color = Color.White)
                    Image(painter = painterResource(id = R.drawable.event_img
                    ), contentDescription = null)

                    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Green),onClick = { /*TODO*/ }) {
                            Text("Save")
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Gray),
                            onClick = { /*TODO*/ }) {
                            Text("Cancel")
                        }
                    }

                }
            )

            LiquidGlassCard3(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(
                    text = "Liquid Glass Card",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "This card has a real blur & transparency just like iOS 18/26.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewMainScreen(){
//    MainScreen()
//}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun SampleScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010)) // Dark background for glass effect
            .padding(32.dp)
    ) {
        LiquidGlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Text(
                text = "Liquid Glass Card",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "This card has a real blur & transparency just like iOS 18/26.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun DemoGlassCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(32.dp)
    ) {
        LiquidGlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentPadding = PaddingValues(24.dp)
        ) {
            Text(
                "Sharp Content",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Text(
                "Only the background is blurred.",
                color = Color.White
            )
        }
    }
}
