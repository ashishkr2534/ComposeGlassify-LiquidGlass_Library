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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                Scaffold(
                    containerColor = Black, modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

//                    MainScreen()
                    UserScreen()
//                    var showDialog by remember { mutableStateOf(true) }
//
//                    if (showDialog) {
//                        GlassifiedAlertDialog(
//                            onDismissRequest = { showDialog = false },
//                            title = {
//                                Text("Delete Item", fontWeight = FontWeight.Bold, color = White)
//                            },
//                            text = {
//                                Text("Are you sure you want to delete this item?", color = White)
//                            },
//                            confirmButton = {
//                                GlassifiedButton(
//                                    onClick = { showDialog = false }
//                                ) {
//                                    Text("Confirm", color = White)
//                                }
//                            },
//                            dismissButton = {
//                                GlassifiedButton(
//                                    onClick = { showDialog = false },
////                                    gradientColors = listOf(Color.Gray.copy(alpha = 0.2f))
//                                ) {
//                                    Text("Cancel", color = White)
//                                }
//                            }
//                        )
//                    }
//                    Column {
//
//
//
//                        CustomGlassifiedCard(
//                            modifier = Modifier
//                                .fillMaxWidth(0.8f)
//                                .height(420.dp),
//                            gradientColors = listOf(
//                                Color.Transparent,
//                                Color.White.copy(alpha = 0.25f),
//                                Color.White.copy(alpha = 0.15f),
//                                Color.Transparent,
////                            Color.White.copy(alpha = 0.5f)
//                            )
//                        )
//                        {
//                            Column(
//                                modifier = Modifier.fillMaxSize(),
////                        verticalArrangement = Arrangement.Center,
////                        horizontalAlignment = Alignment.CenterHorizontally
//                            )
//                            {
//                                Row(
//                                    modifier = Modifier.fillMaxWidth(),
//                                    horizontalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Image(
//                                        painter = painterResource(R.drawable.tiger_img),
//                                        contentDescription = "User Image",
//                                        modifier = Modifier
//                                            .size(80.dp)
//                                            .clip(CircleShape)
//                                            .shadow(0.dp, CircleShape),
//                                        contentScale = ContentScale.Crop
//
//
//                                    )
//
//                                    Column {
//                                        Text(
//                                            "Ashish Kumar",
//                                            fontSize = 25.sp, color = Color.White
//                                        )
//                                        Text("Android App Developer", color = Color.White)
//                                    }
//                                }
//
//                                Spacer(modifier = Modifier.height(15.dp))
//                                Row(
//                                    modifier = Modifier.fillMaxWidth(),
//                                    horizontalArrangement = Arrangement.Start
//                                ) {
//
//                                    Text(
//                                        "This card is here for the user name and there profile details to" +
//                                                "be viewed and seen to public", color = Color.White
//                                    )
//
//
//                                }
//                                Text(
//                                    "Some new for the Android Developer.This card is here for the user name and there profile details to" +
//                                            "be viewed and seen to public", color = Color.White
//                                )
//                                Text(
//                                    "Trying to create a App having the class effect for android Material 3. " +
//                                            "This card is here for the user name and there profile details to" +
//                                            "be viewed and seen to public", color = Color.White
//                                )
//                            }
//                        }
//
//                        GlassifiedButton(onClick = {
//                            showDialog = !showDialog
//                        }) {
//                            Icon(Icons.Default.Star, contentDescription = null, tint = White)
//                            Spacer(modifier = Modifier.width(8.dp))
//                            Text("Glass Button", color = White)
//                        }
//
//
//                    }



//                    CustomGlassifiedCard(
//                        modifier = Modifier
//                            .fillMaxWidth(0.8f)
////                        .width(300.dp)
//                            .height(420.dp)
////                    gradientColors = listOf(
////                        Color.Blue.copy(alpha = 0.1f),
////                        Color.Cyan.copy(alpha = 0.1f)
////                    )
//                    )
//                    {
//                        Column(
//                            modifier = Modifier.fillMaxSize(),
////                        verticalArrangement = Arrangement.Center,
////                        horizontalAlignment = Alignment.CenterHorizontally
//                        )
//                        {
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                Image(
//                                    painter = painterResource(R.drawable.tiger_img),
//                                    contentDescription = "User Image",
//                                    modifier = Modifier
//                                        .size(80.dp)
//                                        .clip(CircleShape)
//                                        .shadow(0.dp, CircleShape),
//                                    contentScale = ContentScale.Crop
//
//
//                                )
//
//                                Column {
//                                    Text(
//                                        "Ashish Kumar",
//                                        fontSize = 25.sp, color = White
//                                    )
//                                    Text("Android App Developer", color = White)
//                                }
//                            }
//
//                            Spacer(modifier = Modifier.height(15.dp))
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                horizontalArrangement = Arrangement.Start
//                            ) {
//
//                                Text(
//                                    "This card is here for the user name and there profile details to" +
//                                            "be viewed and seen to public", color = White
//                                )
//
//
//                            }
//                            Text(
//                                "Some new for the Android Developer.This card is here for the user name and there profile details to" +
//                                        "be viewed and seen to public", color = White
//                            )
//                            Text(
//                                "Trying to create a App having the class effect for android Material 3. " +
//                                        "This card is here for the user name and there profile details to" +
//                                        "be viewed and seen to public", color = White
//                            )
//                        }
//                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var selectedImage by remember {
            mutableStateOf(0)
        }

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

        Image(
            painter = painterResource(
                imageResources[selectedImage]
            ), contentDescription = "background Image",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center
        ) {
            var context = LocalContext.current

            LazyRow(contentPadding = PaddingValues(8.dp)) {
                itemsIndexed(imageResources) { index, imageResId ->
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = "Image", // Provide a more descriptive content description if possible
                        modifier = Modifier
                            .clickable {
                                selectedImage = index
                                Toast.makeText(context, "$selectedImage", Toast.LENGTH_SHORT).show()
                            }
                            .size(100.dp)
                            .padding(horizontal = 4.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }


            LiquidGlass27(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Hello Glass!", color = Color.White)
                    Image(
                        painter = painterResource(
                            id = R.drawable.event_img
                        ), contentDescription = null
                    )

                    LiquidGlassButton2(
                        text = "Check with Me",
                        onClick = {},
                        modifier = Modifier
                            .width(200.dp)
                            .height(56.dp)
                    )

                }
            )

            LiquidGlass26(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Hello Glass!", color = Color.White)
                    Text("Hello some random words chacklcjd Glass!", color = Color.White)
                    Text("Hello jkdc cjejckc omdn Glass!", color = Color.White)
                    Text("someyh hHello Gsgfsflass!", color = Color.White)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Green),
                            onClick = { /*TODO*/ }) {
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

            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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
            LiquidGlass28(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Text("Hello Glass!", color = Color.White)
                    Image(
                        painter = painterResource(
                            id = R.drawable.event_img
                        ), contentDescription = null
                    )

                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Green),
                            onClick = { /*TODO*/ }) {
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
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
                        Text(
                            "GlassCard",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("This content is not blurred", color = Color.White.copy(alpha = 0.8f))
                    }
                }
            }


            Spacer(Modifier.height(20.dp))
            LiquidCardShiny(
                modifier = Modifier
                    .width(300.dp)
                    .height(180.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Glass Card", color = Color.White, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("With shiny edges", color = Color.White.copy(alpha = 0.7f))
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

            Spacer(Modifier.height(600.dp))
            UserScreen()
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
