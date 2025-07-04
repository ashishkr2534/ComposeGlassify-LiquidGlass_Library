package com.ethos.composeglassify



/**
 * Created by Ashish Kr on 28,June,2025
 */


import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
//import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.asComposeRenderEffect // ✅ IMPORTANT

import androidx.compose.ui.graphics.graphicsLayer
//
//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassCard(
//    modifier: Modifier = Modifier,
//    cornerRadius: Dp = 16.dp,
//    blurRadius: Dp = 20.dp,
//    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
//    content: @Composable ColumnScope.() -> Unit
//) {
//    val shape = RoundedCornerShape(cornerRadius)
//    val blurPx = with(LocalDensity.current) { blurRadius.toPx() }
//
//    Box(
//        modifier = modifier
//            .clip(shape)
//            .drawWithContent {
//                drawIntoCanvas { canvas ->
//                    val paint = Paint()
//                    paint.asFrameworkPaint().apply {
//                        isAntiAlias = true
//                        renderEffect = RenderEffect.createBlurEffect(
//                            blurPx,
//                            blurPx,
//                            Shader.TileMode.CLAMP
//                        )
//                    }
//                    val checkpoint = canvas.saveLayer(size.toRect(), paint)
//                    drawContent()
//                    canvas.restoreToCount(checkpoint)
//                }
//            }
//            .background(backgroundColor, shape)
//            .border(1.dp, Color.White.copy(alpha = 0.4f), shape)
//            .padding(16.dp)
//    ) {
//        Column(
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            content()
//        }
//    }
//}

@Composable
fun GlassCard(modifier: Modifier = Modifier){
    Box(modifier = modifier.clip(RoundedCornerShape(15.dp))
        .background(Color.White.copy(alpha = 0.12f))
        .blur(20.dp)
        .border(
            width = 1.dp,
            color = Color.White,
            shape = RoundedCornerShape(16.dp)
        )
        .padding(20.dp)
    ) {
        Column {
            Text(text = "Hello World", color = Color.White)
            Text(text = "Hello World 1", color = Color.White)
            Text(text = "Hello World with Glass Effect", color = Color.White)
        }


    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassCard2(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    blurRadius: Dp = 20.dp,
    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(Color.Transparent)
            .then(
                Modifier.graphicsLayer {
                    renderEffect = RenderEffect
                        .createBlurEffect(
                            blurRadius.value,
                            blurRadius.value,
                            Shader.TileMode.CLAMP
                        )
                        .asComposeRenderEffect()
                }
            )
            .background(backgroundColor)
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.4f),
                shape = RoundedCornerShape(cornerRadius)
            )
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            content()
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassCard(
//    modifier: Modifier = Modifier,
//    cornerRadius: Dp = 16.dp,
//    blurRadius: Dp = 20.dp,
//    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
//    content: @Composable ColumnScope.() -> Unit
//) {
//    val shape = RoundedCornerShape(cornerRadius)
//    val blurPx = with(LocalDensity.current) { blurRadius.toPx() }
//
//    Box(
//        modifier = modifier
//            .clip(shape)
//            .drawBehind {
//                drawIntoCanvas { canvas ->
//                    val paint = android.graphics.Paint().apply {
//                        isAntiAlias = true
//                        renderEffect = RenderEffect.createBlurEffect(
//                            blurPx,
//                            blurPx,
//                            Shader.TileMode.CLAMP
//                        )
//                    }
//                    canvas.nativeCanvas.saveLayer(null, paint)
//                }
//            }
//            .background(backgroundColor, shape)
//            .border(1.dp, Color.White.copy(alpha = 0.4f), shape)
//            .padding(16.dp)
//    ) {
//        Column(
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            content()
//        }
//    }
//}

//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassCard(
//    modifier: Modifier = Modifier,
//    cornerRadius: Dp = 16.dp,
//    blurRadius: Dp = 20.dp,
//    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
//    content: @Composable ColumnScope.() -> Unit
//) {
//    val shape = RoundedCornerShape(cornerRadius)
//    val blurPx = with(LocalDensity.current) { blurRadius.toPx() }
//
//    Box(
//        modifier = modifier
//            .clip(shape)
//            .drawWithContent {
//                drawIntoCanvas { canvas ->
//                    val paint = Paint()
//                    paint.asFrameworkPaint().apply {
//                        isAntiAlias = true
//                        renderEffect = RenderEffect.createBlurEffect(
//                            blurPx,
//                            blurPx,
//                            Shader.TileMode.CLAMP
//                        )
//                    }
//
//                    val checkpoint = canvas.saveLayer(size.toRect(), paint)
//                    drawContent()
//                    canvas.restoreToCount(checkpoint)
//                }
//            }
//            .background(backgroundColor, shape)
//            .border(1.dp, Color.White.copy(alpha = 0.4f), shape)
//            .padding(16.dp)
//    ) {
//        Column(
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            content()
//        }
//    }
//}




//@Preview
//@Composable
//fun GlassCardPreview(){
////    GlassCard()
//}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassCard2New(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    blurRadius: Dp = 20.dp,
    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(Color.Transparent)
            .graphicsLayer {
                renderEffect = RenderEffect
                    .createBlurEffect(
                        blurRadius.value,
                        blurRadius.value,
                        Shader.TileMode.CLAMP
                    )
                    .asComposeRenderEffect()
            }
            .background(backgroundColor)
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.4f),
                shape = RoundedCornerShape(cornerRadius)
            )
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            content()
        }
    }
}
