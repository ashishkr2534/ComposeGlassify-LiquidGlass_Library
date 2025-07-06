package com.ethos.composeglassify

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Ashish Kr on 05,July,2025
 */
//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun LiquidGlassButton(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    text: String,
//    cornerRadius: Dp = 24.dp,
//    blurRadius: Dp = 20.dp
//) {
//    Box(
//        modifier = modifier
//            .clip(RoundedCornerShape(cornerRadius))
//            .background(Color.Transparent)
//            .graphicsLayer {
//                // Apply background blur effect
//                renderEffect = RenderEffect
//                    .createBlurEffect(
//                        blurRadius.value,
//                        blurRadius.value,
//                        Shader.TileMode.CLAMP
//                    )
//                    .asComposeRenderEffect()
//            }
//            .background(
//                brush = Brush.linearGradient(
//                    colors = listOf(
//                        Color.White.copy(alpha = 0.25f),
//                        Color.White.copy(alpha = 0.05f),
//                        Color.Transparent
//                    ),
//                    start = Offset.Zero,
//                    end = Offset.Infinite
//                )
//            )
//            .border(
//                width = 1.dp,
//                color = Color.White.copy(alpha = 0.3f),
//                shape = RoundedCornerShape(cornerRadius)
//            )
//            .clickable(onClick = onClick)
//            .padding(horizontal = 24.dp, vertical = 14.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(
//                    Brush.linearGradient(
//                        colors = listOf(
//                            Color(0xFFB8F1FF).copy(alpha = 0.6f),
//                            Color(0xFFA39EFF).copy(alpha = 0.4f),
//                            Color(0xFFFFC0CB).copy(alpha = 0.4f)
//                        ),
//                        start = Offset.Zero,
//                        end = Offset(200f, 200f)
//                    ),
//                    alpha = 0.25f
//                )
//                .clip(RoundedCornerShape(cornerRadius))
//        ) {
//            Text(
//                text = text,
//                color = Color.White,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.SemiBold,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.align(Alignment.Center)
//            )
//        }
//    }
//}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlassButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    blurRadius: Dp = 20.dp
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .clickable(onClick = onClick)
    ) {
        // Background blur and gradient overlay
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    renderEffect = RenderEffect
                        .createBlurEffect(
                            blurRadius.value,
                            blurRadius.value,
                            Shader.TileMode.CLAMP
                        )
                        .asComposeRenderEffect()
                }
//                .background(
//                    Brush.linearGradient(
//                        colors = listOf(
//                            Color(0xFFB8F1FF).copy(alpha = 0.4f),
//                            Color(0xFFA39EFF).copy(alpha = 0.3f),
//                            Color(0xFFFFC0CB).copy(alpha = 0.3f)
//                        ),
//                        start = Offset.Zero,
//                        end = Offset.Infinite
//                    )
//                )
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.25f),
                            Color.White.copy(alpha = 0.05f),
                            Color.Transparent
                        ),
                        start = Offset.Zero,
                        end = Offset.Infinite
                    )
                )
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(cornerRadius)
                )
        )

        // Foreground content - stays sharp
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(horizontal = 24.dp, vertical = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

