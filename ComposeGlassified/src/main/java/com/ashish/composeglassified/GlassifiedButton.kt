package com.ashish.composeglassified

/**
 * Created by Ashish Kr on 06,July,2025
 */
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassifiedButton(
//    onClick: () -> Unit,
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
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//    shape: Shape = ButtonDefaults.shape,
//    interactionSource: MutableInteractionSource? = null,
//    enabled: Boolean = true,
//
//    content: @Composable RowScope.() -> Unit
//
////    content: @Composable BoxScope.() -> Unit
//)
//{
//    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
//
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
//                    gradientColors,
////                    colors = listOf(
////                        Color.White.copy(alpha = 0.25f),
////                        Color.White.copy(alpha = 0.05f),
////                        Color.Transparent
////                    ),
//                    start = gradientStart,
//                    end = gradientEnd
//                )
//            )
//            .border(
//                width = borderWidth,
//                color = borderColor,
////                color = Color.White.copy(alpha = 0.3f),
//                shape = RoundedCornerShape(cornerRadius)
//            )
////            .clickable(onClick = onClick)
//            .padding(horizontal = 24.dp, vertical = 14.dp)
//    ) {
////        Box(
////            modifier = Modifier
//////                .fillMaxWidth()
//////                .background(
//////                    Brush.linearGradient(
//////                        colors = listOf(
//////                            Color(0xFFB8F1FF).copy(alpha = 0.6f),
//////                            Color(0xFFA39EFF).copy(alpha = 0.4f),
//////                            Color(0xFFFFC0CB).copy(alpha = 0.4f)
//////                        ),
//////                        start = Offset.Zero,
//////                        end = Offset(200f, 200f)
//////                    ),
//////                    alpha = 0.25f
//////                )
////                .clip(RoundedCornerShape(cornerRadius))
////        ) {
//            Surface(
//                onClick = onClick,
//                enabled = enabled,
//                shape = shape,
////        color = colors.containerColor(enabled).value,
////        contentColor = colors.contentColor(enabled).value,
////                border = border,
////                modifier = backgroundModifier.semantics { role = Role.Button },
////        shadowElevation = elevation?.shadowElevation(enabled, resolvedInteractionSource)?.value ?: 0.dp,
//                interactionSource = resolvedInteractionSource
//            ) {
////        ProvideContentColorTextStyle(
////            contentColor = colors.contentColor(enabled).value,
////            textStyle = MaterialTheme.typography.labelLarge
////        ) {
//                Row(
//                    modifier = Modifier.padding(contentPadding),
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically,
//                    content = content
//                )
////        }
//            }
////            content
////        }
//    }
//}

//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassifiedButton(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    shape: Shape = ButtonDefaults.shape,
////    colors: ButtonColors = ButtonDefaults.buttonColors(
////        containerColor = Color.White.copy(alpha = 0.15f),
////        contentColor = Color.White
////    ),
////    elevation: ButtonElevation? = null,
//    border: BorderStroke? = BorderStroke(1.dp, Color.White.copy(alpha = 0.3f)),
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//    interactionSource: MutableInteractionSource? = null,
//    blurRadius: Dp = 20.dp,
//    gradientColors: List<Color> = listOf(
//        Color.White.copy(alpha = 0.25f),
//        Color.White.copy(alpha = 0.05f),
//        Color.Transparent
//    ),
//    gradientStart: Offset = Offset.Zero,
//    gradientEnd: Offset = Offset.Infinite,
//    content: @Composable RowScope.() -> Unit
//) {
//    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
//
//    val backgroundModifier = Modifier
//        .clip(shape)
//        .graphicsLayer {
//            renderEffect = RenderEffect
//                .createBlurEffect(
//                    blurRadius.value,
//                    blurRadius.value,
//                    Shader.TileMode.CLAMP
//                )
//                .asComposeRenderEffect()
//        }
//        .background(
//            Brush.linearGradient(
//                colors = gradientColors,
//                start = gradientStart,
//                end = gradientEnd
//            )
//        )
//        .then(modifier)
//        .defaultMinSize(
//            minWidth = ButtonDefaults.MinWidth,
//            minHeight = ButtonDefaults.MinHeight
//        )
//
//    Surface(
//        onClick = onClick,
//        enabled = enabled,
//        shape = shape,
////        color = colors.containerColor(enabled).value,
////        contentColor = colors.contentColor(enabled).value,
//        border = border,
//        modifier = backgroundModifier.semantics { role = Role.Button },
////        shadowElevation = elevation?.shadowElevation(enabled, resolvedInteractionSource)?.value ?: 0.dp,
//        interactionSource = resolvedInteractionSource
//    ) {
////        ProvideContentColorTextStyle(
////            contentColor = colors.contentColor(enabled).value,
////            textStyle = MaterialTheme.typography.labelLarge
////        ) {
//            Row(
//                modifier = Modifier.padding(contentPadding),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically,
//                content = content
//            )
////        }
//    }
//}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassifiedButton(
    onClick: () -> Unit,
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
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    shape: Shape = ButtonDefaults.shape,
    interactionSource: MutableInteractionSource? = null,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    val resolvedInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
    ) {
        // Background Blur Layer (below content)
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
                        colors = gradientColors,
                        start = gradientStart,
                        end = gradientEnd
                    ),
                    shape = RoundedCornerShape(cornerRadius)
                )
                .border(
                    width = borderWidth,
                    color = borderColor,
                    shape = RoundedCornerShape(cornerRadius)
                )
        )

        // Foreground Surface with content and click handling
        Surface(
            onClick = onClick,
            enabled = enabled,
            shape = shape,
            color = Color.Transparent, // Don't draw anything here
            contentColor = LocalContentColor.current,
            interactionSource = resolvedInteractionSource,
            modifier = Modifier
                .clip(RoundedCornerShape(cornerRadius))
                .padding(contentPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier,
                content = content
            )
        }
    }
}

