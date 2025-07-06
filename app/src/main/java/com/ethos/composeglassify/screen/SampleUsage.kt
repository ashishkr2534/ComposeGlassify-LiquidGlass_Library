package com.ethos.composeglassify.screen

/**
 * Created by Ashish Kr on 06,July,2025
 */
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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.composeglassified.GlassifiedAlertDialog
import com.ashish.composeglassified.GlassifiedButton
import com.ashish.composeglassified.GlassifiedCard
import com.ashish.composeglassified.GlassifiedChip
import com.ashish.composeglassified.GlassifiedSnackbarHost
import com.ashish.composeglassified.GlassifiedSwitch
import com.ethos.composeglassify.LiquidGlassButton
import com.ethos.composeglassify.R
import com.ethos.composeglassify.SampleBottomBar
import kotlinx.coroutines.launch

/**
 * Created by Ashish Kr on 05,July,2025
 */
@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SampleUsageScreen() {

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    if (showDialog) {
        GlassifiedAlertDialog(
            blurRadius = 15.dp,
            gradientColors = listOf(Color.White.copy(alpha = 0.35f),
                Color.White.copy(alpha = 0.25f),
                Color.Transparent),
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
            mutableStateOf(Color.White)
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

        Image(painter = painterResource( imageResources[selectedImage]
//        Image(painter = painterResource( R.drawable.iphonewallpaper
        ), contentDescription = "background Image",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)

        Scaffold( snackbarHost = {
            GlassifiedSnackbarHost(
                hostState = snackbarHostState)
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
                )
                {

//                    Row {
//                        Button(
//                            onClick = {
//                                selectedColor = Color.White
//                            }
//                        ) {
//                            Text("White Text")
//                        }
//                        Button(
//                            onClick = {
//                                selectedColor = Color.Black
//                            }
//                        ) {
//                            Text("Black Text")
//                        }
//                    }
                    LazyRow(contentPadding = PaddingValues(8.dp)) {

                        item {

                        }
                        itemsIndexed(imageResources) { index, imageResId ->
                            Image(
                                painter = painterResource(id = imageResId),
                                contentDescription = "Image", // Provide a more descriptive content description if possible
                                modifier = Modifier.clickable {
                                    selectedImage = index
                                    Toast.makeText(context, "$selectedImage", Toast.LENGTH_SHORT)
                                        .show()
                                }
                                    .size(80.dp).padding(horizontal = 4.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
//                    GlassifiedButton(
//                        onClick = { showDialog = !showDialog },
//                    ) {
//                        Text("Cancel", color = White)
//                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    var selected by remember { mutableStateOf(false) }
//
                    Row() {
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

//                        GlassifiedChip(
//                            text = "Disabled",
//                            enabled = false,
//                            onClick = {}
//                        )
                    }
//                    Spacer(modifier = Modifier.height(10.dp))
//                    Button(onClick = {
//                        scope.launch {
//                            snackbarHostState.showSnackbar(
//                                message = "This is a glassified snackbar",
//                                actionLabel = "UNDO"
//                            )
//                        }
//                    }) {
//                        Text("Show Snackbar")
//                    }

                    var isToggled by remember { mutableStateOf(false) }

                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
//                        verticalArrangement = Arrangement.spacedBy(20.dp)
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

                    Spacer(modifier = Modifier.height(10.dp))
//                    ElevatedCard (colors = CardDefaults.cardColors(Color.Gray),
//                        modifier = Modifier.padding(8.dp)
//                            .fillMaxWidth(0.8f)
//                            .height(420.dp)
//                    )
//                    {
//                        Column(
//                            modifier = Modifier.padding(10.dp)
//                                .fillMaxSize(),
//                        )
//                        {
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                Image(
//                                    painter = painterResource(R.drawable.tiger_img),
//                                    contentDescription = "User Image",
//                                    modifier = Modifier.size(80.dp).clip(CircleShape)
//                                        .shadow(0.dp, CircleShape),
//                                    contentScale = ContentScale.Crop
//
//
//                                )
//
//                                Column {
//                                    Text(
//                                        "Ashish Kumar.",
//                                        fontSize = 25.sp, color = selectedColor
//                                    )
//                                    Text("Android App Developer", color = selectedColor)
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
//                                    "This is a sample card to show use case of this glass type card and use can also add customization to it. "
//                                    , color = selectedColor
//                                )
//
//
//                            }
//                            Text(
//                                "Some new for the Android Developer.This card is here for the user name and there profile details to" +
//                                        "be viewed and seen to public", color = selectedColor
//                            )
//                            Text(
//                                "Trying to create a App having the class effect for android Material 3. " +
//                                        "This card is here for the user name and there profile details to" +
//                                        "be viewed and seen to public", color = selectedColor
//                            )
//                        }
//
//                    }
                    Spacer(modifier = Modifier.height(10.dp))



                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        LiquidGlassButton(
                            text = "Alert ",
                            onClick = {
                                showDialog = !showDialog
                                Toast.makeText(
                                    context,
                                    "Alert Dialog Glassified",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .height(56.dp)
                        )

                        LiquidGlassButton(
                            text = "Dialog",
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Explore Button Clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .height(56.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    LiquidGlassButton(
                        text = "Large Glassified Button",
                        onClick = {
                            Toast.makeText(
                                context,
                                "Explore Button Clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.95f)
                            .height(56.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    LiquidGlassButton(
                        text = "Show SnackBar",
                        onClick = {
                            scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "This is a glassified snackbar",
                                actionLabel = "UNDO"
                            )
                        }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.95f)
                            .height(56.dp)
                    )

                    Spacer(Modifier.height(20.dp))



                    Spacer(Modifier.height(20.dp))
//
//                    LazyRow(contentPadding = PaddingValues(10.dp)) {
//                        items(8) {
//                            LiquidCard(
//                                modifier = Modifier.padding(8.dp)
//                                    .width(200.dp)
//                                    .height(250.dp)
//                            )
//                            {
//                                Column(
//                                    modifier = Modifier.fillMaxSize(),
//                                ) {
//                                    Row(
//                                        modifier = Modifier.fillMaxWidth(),
//                                        horizontalArrangement = Arrangement.SpaceBetween
//                                    ) {
//                                        Image(
//                                            painter = painterResource(R.drawable.tiger_img),
//                                            contentDescription = "User Image",
//                                            modifier = Modifier.size(80.dp)
//                                                .clip(RoundedCornerShape(15.dp))
//                                                .shadow(0.dp, CircleShape),
//                                            contentScale = ContentScale.Crop
//
//
//                                        )
//
//                                        Text(
//                                            "This is a sample card to show use case of this glass type card and use can also add customization to it. "
//                                            , color = selectedColor
//                                        )
//                                        Text(
//                                            "Trying to create a App having the class effect for android Material 3. " +
//                                                    "This card is here for the user name and there profile details to" +
//                                                    "be viewed and seen to public",
//                                            color = selectedColor
//                                        )
//                                    }
//
//                                }
//                            }
//                        }
////
////
//                    }
                }
            }

        }
    }


}
