package com.ethos.composeglassify

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.composeglassified.GlassifiedAlertDialog
import com.ashish.composeglassified.GlassifiedBottomBar
import com.ashish.composeglassified.GlassifiedButton
import com.ashish.composeglassified.GlassifiedChip
import com.ashish.composeglassified.GlassifiedNavigationBarItem
import com.ashish.composeglassified.GlassifiedSnackbarHost
import com.ashish.composeglassified.GlassifiedSwitch
import kotlinx.coroutines.launch

/**
 * Created by Ashish Kr on 05,July,2025
 */
@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserScreen() {

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(true) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    if (showDialog) {
        GlassifiedAlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text("Delete Item", fontWeight = FontWeight.Bold, color = White)
            },
            text = {
                Text("Are you sure you want to delete this item?", color = White)
            },
            confirmButton = {
                GlassifiedButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Confirm", color = White)
                }
            },
            dismissButton = {
                GlassifiedButton(
                    onClick = { showDialog = false },
//                                    gradientColors = listOf(Color.Gray.copy(alpha = 0.2f))
                ) {
                    Text("Cancel", color = White)
                }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        var selectedImage by remember {
            mutableStateOf(0)
        }
        var selectedColor by remember {
            mutableStateOf(Color.Black)
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

        Scaffold( snackbarHost = {
            GlassifiedSnackbarHost(hostState = snackbarHostState)
        },bottomBar = {
            SampleBottomBar(selectedIndex = 0, onItemSelected = {

            })
        },containerColor = Color.Transparent, topBar = {
            CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                title = {
                    Text("User Profile")
                },
                navigationIcon = {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back button")
                }
            )
        }) {
            Box(
                modifier = Modifier.padding(it).fillMaxSize()
//            .padding(16.dp)
            ) {

            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
//            .background(color = Color.Black)
//                    .background(
//                        brush = Brush.linearGradient(
//                            colors = listOf(
//                                Color.Black,
////                    Color.White,
//                                Color.Cyan
//                            )
//                        )
//                    )
            ) {

//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Center
//                )
//                {




                Row {
                    Button(
                        onClick = {
                            selectedColor = Color.White
                        }
                    ) {
                        Text("White Text")
                    }
                    Button(
                        onClick = {
                            selectedColor = Color.Black
                        }
                    ) {
                        Text("Black Text")
                    }
                }
                LazyRow(contentPadding = PaddingValues(8.dp)) {

                    item {

                    }
                    itemsIndexed(imageResources) { index ,imageResId ->
                        Image(
                            painter = painterResource(id = imageResId),
                            contentDescription = "Image", // Provide a more descriptive content description if possible
                            modifier = Modifier.clickable{
                                selectedImage = index
                                Toast.makeText(context, "$selectedImage", Toast.LENGTH_SHORT).show()
                            }
                                .size(80.dp).padding(horizontal = 4.dp).clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                GlassifiedButton(
                    onClick = { showDialog = !showDialog },
//                                    gradientColors = listOf(Color.Gray.copy(alpha = 0.2f))
                ) {
                    Text("Cancel", color = White)
                }
                var selected by remember { mutableStateOf(false) }

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    GlassifiedChip(
                        text = "Filter Chip",
                        selected = selected,
                        onClick = { selected = !selected },
                        showCheckmarkWhenSelected = true
                    )

                    GlassifiedChip(
                        text = "Assist Chip",
                        selected = false,
                        onClick = { /* navigate/help */ },
                        leadingIcon = { Icon(Icons.Default.Info, contentDescription = null) }
                    )

                    GlassifiedChip(
                        text = "Input Chip",
                        selected = true,
                        onClick = { /* maybe open something */ },
                        trailingIcon = {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Clear",
                                modifier = Modifier.size(16.dp)
                            )
                        },
                        onTrailingIconClick = { /* remove chip */ }
                    )

                    GlassifiedChip(
                        text = "Disabled",
                        enabled = false,
                        onClick = {}
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "This is a glassified snackbar",
                            actionLabel = "UNDO"
                        )
                    }
                }) {
                    Text("Show Snackbar")
                }

//                GlassifiedCardNew(
//                    onClick = { /* Navigate or perform action */ },
//                    elevation = 4.dp,
//                    shape = RoundedCornerShape(20.dp)
//                ) {
//                    Text("Glassified Title",
//                        style = MaterialTheme.typography.titleMedium)
//                    Text("This card uses a blur + gradient background.")
//                }


                var isToggled by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    GlassifiedSwitch(
                        checked = isToggled,
                        onCheckedChange = { isToggled = it }
                    )

                    GlassifiedSwitch(
                        checked = isToggled,
                        onCheckedChange = { isToggled = it },
                        onLabel = "ON",
                        offLabel = "OFF",
                        thumbColor = Color.Green,
                        uncheckedThumbColor = Color.Red,
                        switchWidth = 60.dp
                    )

                    GlassifiedSwitch(
                        checked = false,
                        onCheckedChange = {},
                        enabled = false
                    )
                }
//                CustomGlassifiedCard(
//                    modifier = Modifier
//                        .fillMaxWidth(0.8f)
////                        .width(300.dp)
//                        .height(420.dp),
//                    gradientColors = listOf(
//                        Color.Blue.copy(alpha = 4f),
//                        Color.Cyan.copy(alpha = 5f)
//                    )
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
////                        verticalArrangement = Arrangement.Center,
////                        horizontalAlignment = Alignment.CenterHorizontally
//                    )
//                    {
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.SpaceBetween
//                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.tiger_img),
//                                contentDescription = "User Image",
//                                modifier = Modifier.size(80.dp).clip(CircleShape)
//                                    .shadow(0.dp, CircleShape),
//                                contentScale = ContentScale.Crop
//
//
//                            )
//
//                            Column {
//                                Text("Ashish Kumar",
//                                    fontSize = 25.sp, color = selectedColor)
//                                Text("Android App Developer",color = selectedColor)
//                            }
//                        }
//
//                        Spacer(modifier = Modifier.height(15.dp))
//                        Row( modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.Start) {
//
//                            Text("This card is here for the user name and there profile details to" +
//                                    "be viewed and seen to public",color = selectedColor)
//
//
//                        }
//                        Text("Some new for the Android Developer.This card is here for the user name and there profile details to" +
//                                "be viewed and seen to public",color = selectedColor)
//                        Text("Trying to create a App having the class effect for android Material 3. " +
//                                "This card is here for the user name and there profile details to" +
//                                "be viewed and seen to public",color = selectedColor)
//                    }
//                }
                Spacer(modifier = Modifier.height(10.dp))

//                LiquidCardComponent(
//                  card
//                )

//                LiquidCardComponent(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(180.dp),
//                    cornerRadius = 16.dp,
//                    blurRadius = 24.dp,
//                    gradientStart = Offset(5f, 7f),
//                    gradientEnd = Offset(1000f, 1000f),
//                    gradientColors = listOf(
//                        Color.Cyan.copy(alpha = 4f),
//                        Color.Cyan.copy(alpha = 6f),
//                        Color.Cyan.copy(alpha = 0.2f),
//                        Color.Transparent
//                    )
//                ) {
//                    Text("Customizable Liquid Card", color = Color.White)
//                }

                Spacer(modifier = Modifier.height(10.dp))

                LiquidCard(
                    modifier = Modifier
//                        .shadow(5.dp,)
                        .fillMaxWidth(0.8f)
//                        .width(300.dp)
                        .height(420.dp)
                )
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(R.drawable.tiger_img),
                                contentDescription = "User Image",
                                modifier = Modifier.size(80.dp).clip(CircleShape)
                                    .shadow(0.dp, CircleShape),
                                contentScale = ContentScale.Crop


                            )

                            Column {
                                Text("Ashish Kumar",
                                    fontSize = 25.sp, color = selectedColor)
                                Text("Android App Developer",color = selectedColor)
                            }
                        }

                        Spacer(modifier = Modifier.height(15.dp))
                        Row( modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start) {

                            Text("This card is here for the user name and there profile details to" +
                                    "be viewed and seen to public",color = selectedColor)


                        }
                        Text("Some new for the Android Developer.This card is here for the user name and there profile details to" +
                                "be viewed and seen to public",color = selectedColor)
                        Text("Trying to create a App having the class effect for android Material 3. " +
                                "This card is here for the user name and there profile details to" +
                                "be viewed and seen to public",color = selectedColor)
                    }

                }
//                }

                Spacer(Modifier.height(20.dp))

                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    LiquidGlassButton2(
                        text = "Explore ",
                        onClick = {
                            Toast.makeText(context, "Explore Button Clicked", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .width(200.dp)
                            .height(56.dp)
                    )

                    LiquidGlassButton2(
                        text = "Apply",
                        onClick = {
                            Toast.makeText(context, "Explore Button Clicked", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .width(200.dp)
                            .height(56.dp)
                    )
                }

                LazyRow(contentPadding = PaddingValues(10.dp)) {
                    items(8){
                        LiquidCard(
                            modifier = Modifier.padding(8.dp)
//                        .shadow(5.dp,)
//                                .fillMaxWidth(0.8f)
                        .width(200.dp)
                                .height(250.dp)
                        )
                        {
                            Column(
                                modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.tiger_img),
                                        contentDescription = "User Image",
                                        modifier = Modifier.size(80.dp).clip(RoundedCornerShape(15.dp))
                                            .shadow(0.dp, CircleShape),
                                        contentScale = ContentScale.Crop


                                    )

//                                    Column {
//                                        Text("Ashish Kumar",
//                                            fontSize = 25.sp)
//                                        Text("Android App Developer")
//                                    }
                                }

//                                Spacer(modifier = Modifier.height(15.dp))
//                                Row( modifier = Modifier.fillMaxWidth(),
//                                    horizontalArrangement = Arrangement.Start) {
//
//                                    Text("This card is here for the user name and there profile details to" +
//                                            "be viewed and seen to public")
//
//
//                                }
                                Text("Some new for the Android Developer.This card is here for the user name and there profile details to" +
                                        "be viewed and seen to public",color = selectedColor)
                                Text("Trying to create a App having the class effect for android Material 3. " +
                                        "This card is here for the user name and there profile details to" +
                                        "be viewed and seen to public",color = selectedColor)
                            }

                        }
                    }
                }


            }
            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun PreviewSampleScreen(){
    UserScreen()
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun SampleBottomBar(selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    GlassifiedBottomBar {
        GlassifiedNavigationBarItem(
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        GlassifiedNavigationBarItem(
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) },
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorite") },
            label = { Text("Favorites") }
        )
        GlassifiedNavigationBarItem(
            selected = selectedIndex == 2,
            onClick = { onItemSelected(2) },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            alwaysShowLabel = false // Will only show when selected
        )
    }
}
