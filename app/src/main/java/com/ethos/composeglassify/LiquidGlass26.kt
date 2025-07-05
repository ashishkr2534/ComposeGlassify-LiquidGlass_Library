package com.ethos.composeglassify

import android.content.Context
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import eightbitlab.com.blurview.BlurView

//import eightbitlab.com.blurview.BlurView
//import com.github.dimezis.blurview.BlurView
//import com.github.dimezis.blurview.RenderScriptBlur


//import com.eightbitlab.blurview.BlurView
//import com.eightbitlab.blurview.RenderScriptBlur
//import com.eightbitlab.blurview.BlurView
//import com.eightbitlab.blurview.RenderScriptBlur



/**
 * Created by Ashish Kr on 05,July,2025
 */
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlass26(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    blurRadius: Dp = 30.dp,
    backgroundColor: Color = Color.White.copy(alpha = 0.15f),
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
    ) {
        // Blurred Background Layer
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
                .background(backgroundColor)
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Optional border or highlight
        Box(
            modifier = Modifier
                .matchParentSize()
                .border(1.dp, borderColor, RoundedCornerShape(cornerRadius))
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Foreground Content Layer
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            content()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlass27(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    blurRadius: Dp = 30.dp,
    backgroundColor: Color = Color.White.copy(alpha = 0.15f),
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    gradientColors: List<Color> = listOf(
        Color.White.copy(alpha = 0.25f),
        Color.White.copy(alpha = 0.05f)
    ),
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
    ) {
        // Blurred background
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
                .background(backgroundColor)
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Gradient overlay (top to bottom)
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(gradientColors)
                )
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Border
        Box(
            modifier = Modifier
                .matchParentSize()
                .border(1.dp, borderColor, RoundedCornerShape(cornerRadius))
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Foreground content
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            content()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlass28(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    blurRadius: Dp = 30.dp,
    backgroundColor: Color = Color.White.copy(alpha = 0.15f),
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    colorfulGradientColors: List<Color> = listOf(
        Color(0x66FF9A9E),
        Color(0x669F9FFF),
        Color(0x66A1FFCE),
        Color(0x66FBC2EB)
    ),
    shineColor: Color = Color.White.copy(alpha = 0.15f),
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
    ) {
        // Blurred background
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
                .background(backgroundColor)
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Colorful gradient tint (iOS widget style)
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.linearGradient(
                        colors = colorfulGradientColors,
                        start = Offset.Zero,
                        end = Offset.Infinite
                    )
                )
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Diagonal shine highlight
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            shineColor.copy(alpha = 0.0f),
                            shineColor,
                            shineColor.copy(alpha = 0.0f)
                        ),
                        start = Offset.Zero,
                        end = Offset.Infinite
                    )
                )
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Border
        Box(
            modifier = Modifier
                .matchParentSize()
                .border(1.dp, borderColor, RoundedCornerShape(cornerRadius))
                .clip(RoundedCornerShape(cornerRadius))
        )

        // Foreground content
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            content()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlass29(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    blurRadius: Dp = 30.dp,
    gradientTint: Brush = Brush.linearGradient(
        colors = listOf(
            Color(0x80FFFFFF),
            Color(0x40FFC0CB),
            Color(0x4032CD32),
            Color(0x8000FFFF)
        ),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    ),
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    borderWidth: Dp = 1.dp,
    contentPadding: Dp = 16.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)

    Box(
        modifier = modifier
            .clip(shape)
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
            .background(gradientTint, shape)
            .border(borderWidth, borderColor, shape)
            .padding(contentPadding)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            content()
        }
    }
}

@Composable
fun RealGlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    overlayColor: Color = Color.White.copy(alpha = 0.1f),
    blurRadius: Float = 20f,
    content: @Composable BoxScope.() -> Unit
) {
    val context = LocalContext.current
    val viewGroup = LocalView.current.parent as? ViewGroup
    val density = LocalDensity.current
    val cornerPx = with(density) { cornerRadius.toPx() }
//    val blurRadiusPx = with(LocalDensity.current) { blurRadius.toPx() }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
    ) {

        if (viewGroup != null) {
//            AndroidView(
//                modifier = Modifier.matchParentSize(),
//                factory = { ctx ->
//                    BlurView(ctx).apply {
//                        setupWith(viewGroup)
//                            .setBlurAlgorithm(RenderScriptBlur(ctx))
//                            .setBlurRadius(blurRadiusPx)
//                            .setHasFixedTransformationMatrix(true)
//                        overlayColor = overlayColor.toArgb()
//                    }
//                }
//            )
        }

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(16.dp),
            content = content
        )
    }
}
