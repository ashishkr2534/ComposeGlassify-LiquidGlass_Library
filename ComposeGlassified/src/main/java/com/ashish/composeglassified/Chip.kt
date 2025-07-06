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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassifiedChip(
    text: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: () -> Unit,
    onTrailingIconClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    leadingIcon: (@Composable (() -> Unit))? = null,
    trailingIcon: (@Composable (() -> Unit))? = null,
    showCheckmarkWhenSelected: Boolean = true,
    cornerRadius: Dp = 50.dp,
    blurRadius: Dp = 16.dp,
    gradientColors: List<Color> = listOf(
        Color.White.copy(alpha = 0.25f),
        Color.White.copy(alpha = 0.05f),
        Color.Transparent
    ),
    selectedGradientColors: List<Color> = listOf(
        Color(0xFFBBDEFB).copy(alpha = 0.35f),
        Color(0xFF2196F3).copy(alpha = 0.1f),
        Color.Transparent
    ),
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    selectedBorderColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
    borderWidth: Dp = 1.dp,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    selectedTextColor: Color = MaterialTheme.colorScheme.primary,
    disabledAlpha: Float = 0.4f,
    textStyle: TextStyle = MaterialTheme.typography.labelMedium
) {
    val backgroundColors = if (selected) selectedGradientColors else gradientColors
    val effectiveBorderColor = if (selected) selectedBorderColor else borderColor
    val effectiveTextColor = if (!enabled) textColor.copy(alpha = disabledAlpha) else if (selected) selectedTextColor else textColor

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .clickable(
                enabled = enabled,
                onClick = onClick
            )
            .alpha(if (enabled) 1f else disabledAlpha)
    ) {
        // Glass background layer
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
                        colors = backgroundColors
                    ),
                    shape = RoundedCornerShape(cornerRadius)
                )
                .border(
                    width = borderWidth,
                    color = effectiveBorderColor,
                    shape = RoundedCornerShape(cornerRadius)
                )
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            when {
                selected && showCheckmarkWhenSelected -> {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        modifier = Modifier.size(18.dp),
                        tint = effectiveTextColor
                    )
                    Spacer(Modifier.width(6.dp))
                }

                leadingIcon != null -> {
                    leadingIcon()
                    Spacer(Modifier.width(6.dp))
                }
            }

            Text(
                text = text,
                style = textStyle,
                color = effectiveTextColor
            )

            if (trailingIcon != null) {
                Spacer(Modifier.width(6.dp))
                Box(
                    Modifier
                        .clickable(
                            enabled = enabled,
                            onClick = { onTrailingIconClick?.invoke() }
                        )
                        .padding(start = 4.dp)
                ) {
                    trailingIcon()
                }
            }
        }
    }
}

