package com.ethos.composeglassify

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//            .padding(16.dp)
    ){
        var selectedImage by remember {
            mutableStateOf(0)
        }

//        LaunchedEffect(selectedImage) {
//
//        }
        val imageResources = listOf(
            R.drawable.event_img,
            R.drawable.ios_stock_1_for_iphone_x,
            R.drawable.peacock_feather_img,
            R.drawable.pexels_todd_trapani_488382_1535162,
            R.drawable.iphonewallpaper,
            R.drawable.wallpwaper2,
            R.drawable.peacock_feather_img, // Note: duplicate, consider if intended
            R.drawable.tiger_img,
            R.drawable.pexels_iriser_1707215
        )

        Image(painter = painterResource( imageResources[selectedImage]
        ), contentDescription = "background Image",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)

        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center) {
//            GlassCard2New(content = {
//                Text("Glass Card")
//                Image(painter = painterResource(R.drawable.peacock_feather_img), contentDescription = "background Image",
//                    modifier = Modifier.size(150.dp), contentScale = ContentScale.Crop)
//            }

//            )




            var context = LocalContext.current

            LazyRow(contentPadding = PaddingValues(8.dp)) {
                itemsIndexed(imageResources) { index ,imageResId ->
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = "Image", // Provide a more descriptive content description if possible
                        modifier = Modifier.clickable{
                            selectedImage = index
                            Toast.makeText(context, "$selectedImage", Toast.LENGTH_SHORT).show()
                        }
                            .size(100.dp).padding(horizontal = 4.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }


            LiquidGlass27 (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Hello Glass!", color = Color.White)
                    Image(painter = painterResource(id = R.drawable.event_img
                    ), contentDescription = null)

//                    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
//                        Button(
//                            colors = ButtonDefaults.buttonColors(Color.Green),onClick = { /*TODO*/ }) {
//                            Text("Save")
//                        }
//
//                        Button(
//                            colors = ButtonDefaults.buttonColors(Color.Gray),
//                            onClick = { /*TODO*/ }) {
//                            Text("Cancel")
//                        }
//                    }
                    LiquidGlassButton2(
                        text = "Check with Me",
                        onClick = {},
                        modifier = Modifier
                            .width(200.dp)
                            .height(56.dp)
                    )

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

            Row(modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                LiquidGlassButton2(
                    text = "Tap Me",
                    onClick = {},
                    modifier = Modifier
                        .width(200.dp)
                        .height(56.dp)
                )
                LiquidGlassButton2(
                    text = "Close",
                    onClick = {},
                    modifier = Modifier
                        .width(200.dp)
                        .height(56.dp)
                )
            }
//            LiquidGlassButton(
//                text = "Tap Me",
//                onClick = {},
//                modifier = Modifier
//                    .width(200.dp)
//                    .height(56.dp)
//            )
//
//            LiquidGlassButton2(
//                text = "Tap Me",
//                onClick = {},
//                modifier = Modifier
//                    .width(200.dp)
//                    .height(56.dp)
//            )
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

//            LiquidGlass29 (
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(),
//                content = {
//                    Text("Hello Glass!", color = Color.White)
//                    Image(painter = painterResource(id = R.drawable.event_img
//                    ), contentDescription = null)
//
//                    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
//                        Button(
//                            colors = ButtonDefaults.buttonColors(Color.Green),onClick = { /*TODO*/ }) {
//                            Text("Save")
//                        }
//
//                        Button(
//                            colors = ButtonDefaults.buttonColors(Color.Gray),
//                            onClick = { /*TODO*/ }) {
//                            Text("Cancel")
//                        }
//                    }
//
//                }
//            )
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center)
            {
                LiquidCard(
                    modifier = Modifier
                        .width(300.dp)
                        .height(180.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("GlassCard", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("This content is not blurred", color = Color.White.copy(alpha = 0.8f))
                    }
                }
            }


            Spacer(Modifier.height(20.dp))


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
