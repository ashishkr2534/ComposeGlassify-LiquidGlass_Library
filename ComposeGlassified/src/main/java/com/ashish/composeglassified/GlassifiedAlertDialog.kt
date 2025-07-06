package com.ashish.composeglassified

/**
 * Created by Ashish Kr on 06,July,2025
 */
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassifiedAlertDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 24.dp,
    blurRadius: Dp = 20.dp,
    gradientColors: List<Color> = listOf(
        Color.White.copy(alpha = 0.25f),
        Color.White.copy(alpha = 0.05f),
        Color.Transparent
    ),
    gradientStart: Offset = Offset.Zero,
    gradientEnd: Offset = Offset.Infinite,
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    borderWidth: Dp = 1.dp,
    title: (@Composable () -> Unit)? = null,
    text: (@Composable () -> Unit)? = null,
    confirmButton: @Composable () -> Unit,
    dismissButton: (@Composable () -> Unit)? = null,
    shape: Shape = RoundedCornerShape(cornerRadius),
    tonalElevation: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(24.dp)
) {
    val safeGradientColors = if (gradientColors.size < 2) {
        listOf(
            Color.White.copy(alpha = 0.25f),
            Color.White.copy(alpha = 0.05f)
        )
    } else gradientColors

    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = modifier
                .padding(16.dp)
                .clip(shape)
        ) {
            // Blur and glass background
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
                    .background(
                        brush = Brush.linearGradient(
                            colors = safeGradientColors,
                            start = gradientStart,
                            end = gradientEnd
                        ),
                        shape = shape
                    )
                    .border(
                        width = borderWidth,
                        color = borderColor,
                        shape = shape
                    )
            )

            // Content surface
            Surface(
                shape = shape,
                tonalElevation = tonalElevation,
                color = Color.Transparent,
                modifier = Modifier
                    .clip(shape)
                    .padding(contentPadding)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    title?.let {
                        ProvideTextStyle(MaterialTheme.typography.titleLarge.copy(
                            color = LocalContentColor.current.copy(alpha = 1f)
                        )) {
                            it()
                        }
                    }

                    text?.let {
                        ProvideTextStyle(MaterialTheme.typography.bodyMedium.copy(
                            color = LocalContentColor.current.copy(alpha = 1f) // adjusted for readability
                        )) {
                            it()
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        dismissButton?.invoke()
                        Spacer(modifier = Modifier.width(8.dp))
                        confirmButton()
                    }
                }
            }
        }
    }
}


//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassifiedAlertDialog2(
//    onDismissRequest: () -> Unit,
//    modifier: Modifier = Modifier,
//    cornerRadius: Dp = 24.dp,
//    blurRadius: Dp = 20.dp,
//    gradientColors: List<Color> = listOf(
//        Color.White.copy(alpha = 0.25f),
//        Color.White.copy(alpha = 0.05f),
//        Color.Transparent
//    ),
//    gradientStart: Offset = Offset.Zero,
//    gradientEnd: Offset = Offset.Infinite,
//    borderColor: Color = Color.White.copy(alpha = 0.3f),
//    borderWidth: Dp = 1.dp,
//    title: (@Composable () -> Unit)? = null,
//    text: (@Composable () -> Unit)? = null,
//    confirmButton: @Composable () -> Unit,
//    dismissButton: (@Composable () -> Unit)? = null,
//    shape: Shape = RoundedCornerShape(cornerRadius),
//    tonalElevation: Dp = 0.dp,
//    contentPadding: PaddingValues = PaddingValues(24.dp)
//) {
//    val cornerShape = RoundedCornerShape(cornerRadius)
//
//    Dialog(onDismissRequest = onDismissRequest) {
//        Box(
//            modifier = modifier
//                .padding(16.dp)
//                .clip(cornerShape)
//        ) {
//            // Glass Blur + Gradient + Border
//            Box(
//                modifier = Modifier
//                    .matchParentSize()
//                    .graphicsLayer {
//                        renderEffect = RenderEffect
//                            .createBlurEffect(
//                                blurRadius.value,
//                                blurRadius.value,
//                                Shader.TileMode.CLAMP
//                            )
//                            .asComposeRenderEffect()
//                    }
//                    .background(
//                        brush = Brush.linearGradient(
//                            colors = gradientColors,
//                            start = gradientStart,
//                            end = gradientEnd
//                        ),
//                        shape = cornerShape
//                    )
//                    .border(
//                        width = borderWidth,
//                        color = borderColor,
//                        shape = cornerShape
//                    )
//            )
//
//            // Foreground Transparent Surface (like Button)
//            Surface(
//                shape = cornerShape,
//                tonalElevation = tonalElevation,
//                color = Color.Transparent,
//                modifier = Modifier
//                    .clip(cornerShape)
//                    .padding(contentPadding)
//            ) {
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(16.dp),
//                    horizontalAlignment = Alignment.Start
//                ) {
//                    title?.let {
//                        ProvideTextStyle(MaterialTheme.typography.titleLarge.copy(
//                            color = LocalContentColor.current.copy(alpha = 1f)
//                        )) {
//                            it()
//                        }
//                    }
//
//                    text?.let {
//                        ProvideTextStyle(MaterialTheme.typography.bodyMedium.copy(
//                            color = LocalContentColor.current.copy(alpha = 0.9f)
//                        )) {
//                            it()
//                        }
//                    }
//
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 8.dp),
//                        horizontalArrangement = Arrangement.End
//                    ) {
//                        dismissButton?.invoke()
//                        Spacer(modifier = Modifier.width(8.dp))
//                        confirmButton()
//                    }
//                }
//            }
//        }
//    }
//}
