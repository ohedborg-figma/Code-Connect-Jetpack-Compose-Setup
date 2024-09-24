package com.example.bankingexample

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingexample.data.BottomNavigation
import com.example.bankingexample.ui.theme.Black
import com.example.bankingexample.ui.theme.LightOrange

// Use the Departure Mono font
val departureMonoFontFamily = FontFamily(
    Font(R.font.chromo, FontWeight.Normal)
)

val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavigation(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),
    BottomNavigation(
        title = "Updates",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavigation(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)

@Composable
fun BottomNavigationBar() {
    // Use square corners and the TVA-style black and orange color scheme
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp) // Consistent padding for alignment with layout
            .background(Black) // Use dark background matching the TVA grid
            .border(3.dp, LightOrange) // Square corners with orange border
            .padding(8.dp),
        containerColor = Black, // Set container color same as the background grid color
    ) {
        Row(
            modifier = Modifier
                .background(Black) // Ensure background is consistent with the grid
                .padding(8.dp) // Padding for spacing between icons and edges
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = index == 0 // Example selection for "Home"

                NavigationBarItem(
                    selected = isSelected,
                    onClick = { /* Handle item click */ },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = LightOrange,
                            modifier = Modifier
                                .padding(4.dp) // Adjust padding for visual alignment
                                .then(
                                    if (isSelected) Modifier
                                        .graphicsLayer {
                                            shadowElevation = 16f // Elevation for glowing effect
                                        }
                                        .shadow(
                                            elevation = 14.dp, // Shadow to simulate glow
                                            shape = CircleShape, // Circle shape for glowing effect
                                            ambientColor = LightOrange, // Glow color
                                            spotColor = LightOrange
                                        )
                                    else Modifier
                                )
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = LightOrange, // Use orange for text color consistency
                            fontWeight = FontWeight.Medium,
                            fontFamily = departureMonoFontFamily, // Use Departure Mono font for label text
                            fontSize = 12.sp // Adjust font size for better alignment
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = LightOrange, // Keep icon orange when selected
                        unselectedIconColor = LightOrange, // Keep icon orange when unselected
                        selectedTextColor = LightOrange, // Keep text orange when selected
                        unselectedTextColor = LightOrange, // Keep text orange when unselected
                        indicatorColor = Color.Transparent // Remove default gray highlight background
                    ),
                    modifier = Modifier
                        .background(Color.Transparent) // Transparent background for items
                        .padding(8.dp)
                )
            }
        }
    }
}
