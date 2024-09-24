package com.example.bankingexample

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.Cases
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingexample.data.Finance
import com.example.bankingexample.ui.theme.BlueStart
import com.example.bankingexample.ui.theme.GreenStart
import com.example.bankingexample.ui.theme.LightOrange
import com.example.bankingexample.ui.theme.OrangeStart
import com.example.bankingexample.ui.theme.PurpleStart

// Define the finance list
val financeList = listOf(
    Finance(
        icon = Icons.Rounded.Cases,
        name = "My\nBusiness",
        background = OrangeStart,
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart,
    ),
    Finance(
        icon = Icons.Rounded.Analytics,
        name = "Finance\nAnalytics",
        background = PurpleStart,
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "Finance\nTransactions",
        background = GreenStart,
    ),
)

@Preview
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 20.sp,
            color = LightOrange, // Consistent theme color
            fontWeight = FontWeight.Bold,
            fontFamily = departureMonoFontFamily, // Use the custom font
            modifier = Modifier.padding(16.dp),
        )
        LazyRow {
            items(financeList.size) {
                FinanceItem(it)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if (index == financeList.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp)) // Rounded corners for the card
                .background(Color.Black) // Card background color
                .border(2.dp, LightOrange, RoundedCornerShape(16.dp)) // Add glowing border to card
                .size(131.dp)
                .clickable {}
                .padding(13.dp), // Padding inside the card
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Icon Box with glowing orange background and icon
            Box(
                modifier = Modifier
                    .clip(CircleShape) // Circular background for the icon
                    .background(LightOrange) // Orange background for the icon
                    .padding(10.dp)
                    .border(
                        2.dp,
                        LightOrange.copy(alpha = 0.7f), // Light orange glowing border
                        CircleShape
                    ) // Border with glowing effect
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White, // Set the icon color to white for contrast
                    modifier = Modifier.size(28.dp) // Size of the icon
                )
            }
            // Finance name with glowing effect
            Text(
                text = finance.name,
                fontSize = 14.sp, // Slightly increased font size for readability
                color = LightOrange, // Text color consistent with theme
                fontWeight = FontWeight.Bold,
                fontFamily = departureMonoFontFamily, // Use the sci-fi font
                style = TextStyle(
                    shadow = Shadow(
                        color = LightOrange,
                        blurRadius = 10f // Glowing effect for text
                    )
                )
            )
        }
    }
}
