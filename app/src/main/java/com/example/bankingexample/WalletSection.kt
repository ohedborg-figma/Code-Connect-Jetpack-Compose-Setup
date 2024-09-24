package com.example.bankingexample

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.bankingexample.ui.theme.Black
import com.example.bankingexample.ui.theme.LightOrange

@Preview
@Composable
fun WalletSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Black),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Column {
            // Apply Departure Mono font to the Wallet label
            Text(
                text = "Wallet",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = LightOrange, // Set text color to light orange
                fontFamily = departureMonoFontFamily, // Use the Departure Mono font
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Apply Departure Mono font to the balance
            Text(
                text = "$ 13.37",
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold, // Make the amount stand out
                color = Color.White, // Set the amount text color to white
                fontFamily = departureMonoFontFamily, // Use the Departure Mono font
            )
        }

        // Search Icon Box
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(LightOrange) // Set background to light orange for contrast
                .clickable {}
                .padding(6.dp) // Add padding inside the search icon box
                .width(40.dp)
                .height(40.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search",
                tint = Black, // Set the icon tint to black for contrast
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp),
            )
        }
    }
}
