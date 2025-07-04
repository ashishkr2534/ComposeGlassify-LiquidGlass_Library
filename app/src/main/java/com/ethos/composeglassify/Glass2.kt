package com.ethos.composeglassify

/**
 * Created by Ashish Kr on 28,June,2025
 */
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.asComposeRenderEffect // ✅ IMPORTANT
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun LiquidGlassCard(
//    modifier: Modifier = Modifier,
//    cornerRadius: Dp = 20.dp,
//    blurRadius: Float = 40f,
//    backgroundColor: Color = Color.White.copy(alpha = 0.2f),
//    borderColor: Color = Color.White.copy(alpha = 0.6f),
//    contentPadding: PaddingValues = PaddingValues(16.dp),
//    content: @Composable ColumnScope.() -> Unit
//) {
//    Box(
//        modifier = modifier
//            .clip(RoundedCornerShape(cornerRadius))
//            .graphicsLayer {
//                renderEffect = RenderEffect
//                    .createBlurEffect(
//                        blurRadius,
//                        blurRadius,
//                        Shader.TileMode.CLAMP
//                    )
//                    .asComposeRenderEffect() // ✅ Convert here
//            }
//            .background(backgroundColor)
//            .border(1.dp, borderColor, RoundedCornerShape(cornerRadius))
//            .padding(contentPadding)
//    ) {
//        Column(content = content)
//    }
//}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    blurRadius: Float = 40f,
    backgroundColor: Color = Color.White.copy(alpha = 0.14f),
    borderColor: Color = Color.White.copy(alpha = 0.4f),
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)

    Box(
        modifier = modifier
            .clip(shape)
            .border(1.dp, borderColor, shape)
    ) {
        // Background blur layer
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(shape)
                .graphicsLayer {
                    renderEffect = RenderEffect
                        .createBlurEffect(
                            blurRadius,
                            blurRadius,
                            Shader.TileMode.CLAMP
                        )
                        .asComposeRenderEffect()
                }
                .background(backgroundColor)
        )

        // Foreground content layer
        Column(
            modifier = Modifier
                .clip(shape)
                .padding(contentPadding),
            content = content
        )
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlassNeonCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    blurRadius: Float = 30f,
    borderColor: Color = Color(0xFF9A56FF).copy(alpha = 0.4f), // Neon Violet
    backgroundColor: Color = Color.Black.copy(alpha = 0.35f),   // Semi-transparent dark
    contentPadding: PaddingValues = PaddingValues(20.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)

    Box(
        modifier = modifier
            .clip(shape)
    ) {
        // Blurred backdrop
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    renderEffect = RenderEffect
                        .createBlurEffect(blurRadius, blurRadius, Shader.TileMode.CLAMP)
                        .asComposeRenderEffect()
                }
                .background(backgroundColor)
                .clip(shape)
        )

        // Neon border
        Box(
            modifier = Modifier
                .matchParentSize()
                .border(
                    width = 1.5.dp,
                    color = borderColor,
                    shape = shape
                )
        )

        // Foreground content
        Column(
            modifier = Modifier
                .clip(shape)
                .padding(contentPadding),
            content = content
        )
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlassCard2(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    blurRadius: Float = 40f,
    backgroundColor: Color = Color.White.copy(alpha = 0.15f),
    borderColor: Color = Color.White.copy(alpha = 0.35f),
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)

    Box(
        modifier = modifier
            .clip(shape)
            .background(Color.Transparent)
    ) {
        // ✅ Pure background blur using AndroidView
        AndroidView(
            factory = { context ->
                View(context).apply {
                    background = ColorDrawable(android.graphics.Color.TRANSPARENT)
                    setLayerType(View.LAYER_TYPE_HARDWARE, null)
                    setRenderEffect(
                        RenderEffect.createBlurEffect(
                            blurRadius,
                            blurRadius,
                            Shader.TileMode.CLAMP
                        )
                    )
                }
            },
            modifier = Modifier
                .matchParentSize()
                .clip(shape)
        )

        // ✅ Translucent background color over blurred background
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(shape)
                .background(backgroundColor)
                .border(1.dp, borderColor, shape)
        )

        // ✅ Foreground content remains sharp
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .clip(shape),
            content = content
        )
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LiquidGlassCard3(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 20.dp,
    blurRadius: Float = 50f,
    backgroundColor: Color = Color.White.copy(alpha = 0.12f),
    borderColor: Color = Color.White.copy(alpha = 0.25f),
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(cornerRadius)

    Box(
        modifier = modifier
            .clip(shape)
            .border(1.dp, borderColor, shape)
    ) {
        // Blurred background only
        AndroidView(
            modifier = Modifier
                .matchParentSize()
                .clip(shape),
            factory = { context ->
                View(context).apply {
                    setBackgroundColor(Color.Transparent.toArgb())
                    setLayerType(View.LAYER_TYPE_HARDWARE, null)
                    setRenderEffect(
                        RenderEffect.createBlurEffect(
                            blurRadius,
                            blurRadius,
                            Shader.TileMode.CLAMP
                        )
                    )
                }
            }
        )

        // Frosted glass color overlay
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(shape)
                .background(backgroundColor)
        )

        // Foreground content (unblurred)
        Column(
            modifier = Modifier
                .clip(shape)
                .padding(contentPadding),
            content = content
        )
    }
}


