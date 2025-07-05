package com.ethos.composeglassify

/**
 * Created by Ashish Kr on 05,July,2025
 */

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
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
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    blurRadius: Dp = 20.dp,
    gradientColors: List<Color> = listOf(
        Color(0xFFB8F1FF).copy(alpha = 0.12f),
        Color(0xFFA39EFF).copy(alpha = 0.12f),
        Color(0xFFFFC0CB).copy(alpha = 0.15f)
    ),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
    ) {
        // Background blur + gradient
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
//                        colors = gradientColors,
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

        // Foreground content (sharp)
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(16.dp),
            content = content
        )
    }
}
