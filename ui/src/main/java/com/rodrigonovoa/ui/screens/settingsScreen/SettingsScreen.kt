package com.rodrigonovoa.ui.screens.settingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodrigonovoa.ui.theme.AccentBlue
import com.rodrigonovoa.ui.theme.AccentPurple
import com.rodrigonovoa.ui.theme.AccentRed
import com.rodrigonovoa.ui.theme.AccentTeal
import com.rodrigonovoa.ui.theme.SettingsArrowColor

data class SettingItem(
    val icon: ImageVector,
    val label: String,
    val accentStart: Color,
    val accentEnd: Color,
    val onClick: () -> Unit
)

@Composable
fun SettingsScreen() {
    Column {
        val items = listOf(
            SettingItem(
                icon        = Icons.Outlined.Settings,
                label       = "Change color",
                accentStart = AccentBlue,
                accentEnd   = AccentPurple,
                onClick     = { }
            ),
            SettingItem(
                icon        = Icons.Outlined.AccountCircle,
                label       = "Change language",
                accentStart = AccentTeal,
                accentEnd   = AccentBlue,
                onClick     = { }
            ),
            SettingItem(
                icon        = Icons.Outlined.Delete,
                label       = "Clean data",
                accentStart = AccentRed,
                accentEnd   = Color(0xFFFF9A5C),
                onClick     = { }
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Settings",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            )

            Spacer(modifier = Modifier.height(28.dp))

            items.forEachIndexed { index, item ->
                SettingButton(item = item)
                if (index < items.lastIndex) {
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun SettingButton(item: SettingItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(
                    listOf(item.accentStart.copy(alpha = 0.4f), item.accentEnd.copy(alpha = 0.15f))
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { item.onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        Brush.linearGradient(listOf(item.accentStart, item.accentEnd))
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.label,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.label,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.2.sp
                )
            }

            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = null,
                tint = SettingsArrowColor,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
