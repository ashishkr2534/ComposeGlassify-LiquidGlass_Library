package com.ashish.composeglassified

/**
 * Created by Ashish Kr on 06,July,2025
 */
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassifiedSwitch(
//    checked: Boolean,
//    onCheckedChange: (Boolean) -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    onLabel: String? = null,
//    offLabel: String? = null,
//    thumbColor: Color = MaterialTheme.colorScheme.primary,
//    uncheckedThumbColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
//    trackColor: Color = MaterialTheme.colorScheme.surface.copy(alpha = 0.2f),
//    checkedTrackGradient: List<Color> = listOf(
//        Color.White.copy(alpha = 0.2f),
//        Color.Transparent
//    ),
//    uncheckedTrackGradient: List<Color> = listOf(
//        Color.Black.copy(alpha = 0.2f),
//        Color.Transparent
//    ),
//    cornerRadius: Dp = 20.dp,
//    blurRadius: Dp = 16.dp,
//    borderWidth: Dp = 1.dp,
//    borderColor: Color = Color.White.copy(alpha = 0.3f),
//    disabledAlpha: Float = 0.4f,
//    thumbSize: Dp = 20.dp,
//    switchWidth: Dp = 46.dp,
//    switchHeight: Dp = 26.dp
//) {
//    val transition = updateTransition(checked, label = "switch_transition")
//    val thumbOffset by transition.animateDp(label = "thumb_offset") {
//        if (it) switchWidth - thumbSize - 4.dp else 4.dp
//    }
//    val currentThumbColor = if (!enabled) uncheckedThumbColor.copy(alpha = disabledAlpha)
//    else if (checked) thumbColor else uncheckedThumbColor
//
//    val trackGradient = if (checked) checkedTrackGradient else uncheckedTrackGradient
//
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier
//            .toggleable(
//                value = checked,
//                onValueChange = { if (enabled) onCheckedChange(it) },
//                enabled = enabled,
//                role = Role.Switch
//            )
//            .alpha(if (enabled) 1f else disabledAlpha)
//    ) {
//        // Optional label
//        if (offLabel != null && !checked) {
//            Text(offLabel, style = MaterialTheme.typography.labelMedium, modifier = Modifier.padding(end = 8.dp))
//        }
//        if (onLabel != null && checked) {
//            Text(onLabel, style = MaterialTheme.typography.labelMedium, modifier = Modifier.padding(end = 8.dp))
//        }
//
//        Box(
//            modifier = Modifier
//                .size(width = switchWidth, height = switchHeight)
//                .clip(RoundedCornerShape(cornerRadius))
//                .graphicsLayer {
//                    renderEffect = RenderEffect
//                        .createBlurEffect(
//                            blurRadius.value,
//                            blurRadius.value,
//                            Shader.TileMode.CLAMP
//                        )
//                        .asComposeRenderEffect()
//                }
//                .background(
//                    brush = Brush.linearGradient(colors = trackGradient),
//                    shape = RoundedCornerShape(cornerRadius)
//                )
//                .border(
//                    width = borderWidth,
//                    color = borderColor,
//                    shape = RoundedCornerShape(cornerRadius)
//                )
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(thumbSize)
//                    .offset(x = thumbOffset)
//                    .padding(2.dp)
//                    .background(
//                        color = currentThumbColor,
//                        shape = CircleShape
//                    )
//                    .align(Alignment.CenterStart)
//            )
//        }
//    }
//}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassifiedSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onLabel: String? = null,
    offLabel: String? = null,
    thumbColor: Color = MaterialTheme.colorScheme.primary,
    uncheckedThumbColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
    trackColor: Color = MaterialTheme.colorScheme.surface.copy(alpha = 0.2f),
    checkedTrackGradient: List<Color> = listOf(
        Color.White.copy(alpha = 0.2f),
        Color.Transparent
    ),
    uncheckedTrackGradient: List<Color> = listOf(
        Color.Black.copy(alpha = 0.2f),
        Color.Transparent
    ),
    cornerRadius: Dp = 20.dp,
    blurRadius: Dp = 16.dp,
    borderWidth: Dp = 1.dp,
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    disabledAlpha: Float = 0.4f,
    thumbSize: Dp = 20.dp,
    switchWidth: Dp = 46.dp,
    switchHeight: Dp = 26.dp
) {
    val transition = updateTransition(checked, label = "switch_transition")
    val thumbOffset by transition.animateDp(label = "thumb_offset") {
        if (it) switchWidth - thumbSize - 4.dp else 4.dp
    }
    val currentThumbColor = when {
        !enabled -> uncheckedThumbColor.copy(alpha = disabledAlpha)
        checked -> thumbColor
        else -> uncheckedThumbColor
    }

    val trackGradient = if (checked) checkedTrackGradient else uncheckedTrackGradient

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .toggleable(
                value = checked,
                onValueChange = { if (enabled) onCheckedChange(it) },
                enabled = enabled,
                role = Role.Switch
            )
            .alpha(if (enabled) 1f else disabledAlpha)
    ) {
        // Labels (outside blur)
        Text(
            text = if (checked) onLabel ?: "" else offLabel ?: "",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1
        )

        // Switch with blur only on background
        Box(
            modifier = Modifier
                .size(width = switchWidth, height = switchHeight)
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
                    .background(
                        brush = Brush.linearGradient(colors = trackGradient),
                        shape = RoundedCornerShape(cornerRadius)
                    )
                    .border(
                        width = borderWidth,
                        color = borderColor,
                        shape = RoundedCornerShape(cornerRadius)
                    )
            )

            // Thumb
            Box(
                modifier = Modifier
                    .size(thumbSize)
                    .offset(x = thumbOffset)
                    .background(
                        color = currentThumbColor,
                        shape = CircleShape
                    )
                    .align(Alignment.CenterStart)
            )
        }
    }
}
