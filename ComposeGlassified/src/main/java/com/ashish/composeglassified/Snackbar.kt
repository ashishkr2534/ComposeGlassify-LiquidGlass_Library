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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//@RequiresApi(Build.VERSION_CODES.S)
//@Composable
//fun GlassifiedSnackbar(
//    snackbarData: SnackbarData,
//    modifier: Modifier = Modifier,
//    cornerRadius: Dp = 16.dp,
//    blurRadius: Dp = 20.dp,
//    gradientColors: List<Color> = listOf(
//        Color.White.copy(alpha = 0.15f),
//        Color.White.copy(alpha = 0.05f),
//        Color.Transparent
//    ),
//    borderColor: Color = Color.White.copy(alpha = 0.2f),
//    borderWidth: Dp = 1.dp,
//    textColor: Color = MaterialTheme.colorScheme.onSurface,
//    actionColor: Color = MaterialTheme.colorScheme.primary,
//    shape: Shape = RoundedCornerShape(16.dp)
//) {
//    Box(
//        modifier = modifier
//            .padding(horizontal = 16.dp, vertical = 8.dp)
//            .fillMaxWidth()
//            .clip(shape)
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
//                brush = Brush.linearGradient(gradientColors),
//                shape = shape
//            )
//            .border(
//                width = borderWidth,
//                color = borderColor,
//                shape = shape
//            )
//            .padding(horizontal = 16.dp, vertical = 12.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = snackbarData.visuals.message,
//                color = textColor,
//                style = MaterialTheme.typography.bodyMedium,
//                modifier = Modifier.weight(1f)
//            )
//            snackbarData.visuals.actionLabel?.let { label ->
//                Spacer(modifier = Modifier.width(8.dp))
//                TextButton(
//                    onClick = { snackbarData.performAction() },
//                    contentPadding = PaddingValues(0.dp)
//                ) {
//                    Text(
//                        text = label.uppercase(),
//                        color = actionColor,
//                        style = MaterialTheme.typography.labelLarge
//                    )
//                }
//            }
//        }
//    }
//}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassifiedSnackbar(
    snackbarData: SnackbarData,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 16.dp,
    blurRadius: Dp = 20.dp,
    gradientColors: List<Color> = listOf(
        Color.White.copy(alpha = 0.15f),
        Color.White.copy(alpha = 0.05f),
        Color.Transparent
    ),
    borderColor: Color = Color.White.copy(alpha = 0.2f),
    borderWidth: Dp = 1.dp,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    actionColor: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = RoundedCornerShape(16.dp)
) {
    Box(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clip(shape)
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
                .background(
                    brush = Brush.linearGradient(gradientColors),
                    shape = shape
                )
                .border(
                    width = borderWidth,
                    color = borderColor,
                    shape = shape
                )
        )

        // Foreground Content Layer
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = snackbarData.visuals.message,
                color = textColor,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            snackbarData.visuals.actionLabel?.let { label ->
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(
                    onClick = { snackbarData.performAction() },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = label.uppercase(),
                        color = actionColor,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GlassifiedSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier,
        snackbar = { data ->
            GlassifiedSnackbar(
                textColor = Color.White, snackbarData = data)
        }
    )
}

