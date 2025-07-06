package com.ashish.composeglassified

/**
 * Created by Ashish Kr on 06,July,2025
 */

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassifiedNavigationBarItem(
//    selected: Boolean,
//    onClick: () -> Unit,
//    icon: @Composable () -> Unit,
//    label: (@Composable () -> Unit)? = null,
//    alwaysShowLabel: Boolean = true,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    selectedContentColor: Color = MaterialTheme.colorScheme.primary,
//    unselectedContentColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
//    cornerRadius: Dp = 16.dp,
//    blurRadius: Dp = 20.dp,
//    gradientColors: List<Color> = listOf(
//        Color.White.copy(alpha = 0.25f),
//        Color.White.copy(alpha = 0.05f),
//        Color.Transparent
//    ),
//    gradientStart: Offset = Offset.Zero,
//    gradientEnd: Offset = Offset.Infinite,
//    borderColor: Color = Color.White.copy(alpha = 0.3f),
//    borderWidth: Dp = 1.dp
//) {
//    val contentColor by remember(selected, enabled) {
//        mutableStateOf(
//            if (!enabled) unselectedContentColor.copy(alpha = 0.38f)
//            else if (selected) selectedContentColor
//            else unselectedContentColor
//        )
//    }
//
//    val interactionSource = remember { MutableInteractionSource() }
//
//    val labelVisible = alwaysShowLabel || selected
//
//    Column(
//        modifier = modifier
//            .clip(RoundedCornerShape(cornerRadius))
//            .clickable(
//                interactionSource = interactionSource,
//                indication = LocalIndication.current,
//                enabled = enabled,
//                onClick = onClick
//            )
//            .padding(horizontal = 12.dp, vertical = 8.dp)
//            .graphicsLayer {
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
//                    colors = gradientColors,
//                    start = gradientStart,
//                    end = gradientEnd
//                ),
//                shape = RoundedCornerShape(cornerRadius)
//            )
//            .border(
//                width = borderWidth,
//                color = borderColor,
//                shape = RoundedCornerShape(cornerRadius)
//            ),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        CompositionLocalProvider(LocalContentColor provides contentColor) {
//            icon()
//
//            if (label != null && labelVisible) {
//                Spacer(modifier = Modifier.height(4.dp))
//                ProvideTextStyle(MaterialTheme.typography.labelSmall.copy(color = contentColor)) {
//                    label()
//                }
//            }
//        }
//    }
//}


//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassifiedNavigationBarItem(
//    selected: Boolean,
//    onClick: () -> Unit,
//    icon: @Composable () -> Unit,
//    label: (@Composable () -> Unit)? = null,
//    alwaysShowLabel: Boolean = true,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    selectedContentColor: Color = MaterialTheme.colorScheme.primary,
//    unselectedContentColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
//    cornerRadius: Dp = 16.dp,
//    blurRadius: Dp = 20.dp,
//    gradientColors: List<Color> = listOf(
//        Color.White.copy(alpha = 0.25f),
//        Color.White.copy(alpha = 0.05f),
//        Color.Transparent
//    ),
//    gradientStart: Offset = Offset.Zero,
//    gradientEnd: Offset = Offset.Infinite,
//    borderColor: Color = Color.White.copy(alpha = 0.3f),
//    borderWidth: Dp = 1.dp
//)
//{
//    val contentColor by remember(selected, enabled) {
//        mutableStateOf(
//            if (!enabled) unselectedContentColor.copy(alpha = 0.38f)
//            else if (selected) selectedContentColor
//            else unselectedContentColor
//        )
//    }
//
//    val interactionSource = remember { MutableInteractionSource() }
//
//    val labelVisible = alwaysShowLabel || selected
//
//    Column(
//        modifier = modifier
//            .clip(RoundedCornerShape(cornerRadius))
//            .clickable(
//                interactionSource = interactionSource,
//                indication = LocalIndication.current,
//                enabled = enabled,
//                onClick = onClick
//            )
//            .padding(horizontal = 12.dp, vertical = 8.dp)
//            .graphicsLayer {
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
//                    colors = gradientColors,
//                    start = gradientStart,
//                    end = gradientEnd
//                ),
//                shape = RoundedCornerShape(cornerRadius)
//            )
//            .border(
//                width = borderWidth,
//                color = borderColor,
//                shape = RoundedCornerShape(cornerRadius)
//            ),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        CompositionLocalProvider(LocalContentColor provides contentColor) {
//            icon()
//
//            if (label != null && labelVisible) {
//                Spacer(modifier = Modifier.height(4.dp))
//                ProvideTextStyle(MaterialTheme.typography.labelSmall.copy(color = contentColor)) {
//                    label()
//                }
//            }
//        }
//    }
//}
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassifiedNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: (@Composable () -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedContentColor: Color = MaterialTheme.colorScheme.primary,
    unselectedContentColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    cornerRadius: Dp = 16.dp,
    gradientColors: List<Color> = listOf(
        Color.White.copy(alpha = 0.25f),
        Color.White.copy(alpha = 0.05f),
        Color.Transparent
    ),
    gradientStart: Offset = Offset.Zero,
    gradientEnd: Offset = Offset.Infinite,
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    borderWidth: Dp = 1.dp
) {
    val contentColor by remember(selected, enabled) {
        mutableStateOf(
            if (!enabled) unselectedContentColor.copy(alpha = 0.38f)
            else if (selected) selectedContentColor
            else unselectedContentColor
        )
    }

    val interactionSource = remember { MutableInteractionSource() }
    val labelVisible = alwaysShowLabel || selected

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                enabled = enabled,
                onClick = onClick
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColors,
                    start = gradientStart,
                    end = gradientEnd
                ),
                shape = RoundedCornerShape(cornerRadius)
            )
//            .border(
//                width = borderWidth,
//                color = borderColor,
//                shape = RoundedCornerShape(cornerRadius)
//            )
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            icon()

            if (label != null && labelVisible) {
                Spacer(modifier = Modifier.height(4.dp))
                ProvideTextStyle(MaterialTheme.typography.labelSmall.copy(color = contentColor)) {
                    label()
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassifiedBottomBar(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    tonalElevation: Dp = NavigationBarDefaults.Elevation,
    cornerRadius: Dp = 0.dp,
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
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(cornerRadius)),
        color = Color.Transparent,
        tonalElevation = tonalElevation,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
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

            // Foreground content (not blurred)
            Row(
                modifier = Modifier
                    .padding(contentPadding)
                    .navigationBarsPadding()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}
