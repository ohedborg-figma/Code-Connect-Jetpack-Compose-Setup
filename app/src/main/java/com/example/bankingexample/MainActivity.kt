package com.example.bankingexample

import CurrenciesSection
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingexample.ui.theme.BankingExampleTheme
import com.example.bankingexample.ui.theme.LightOrange
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // This enables edge-to-edge content on supported devices
        setContent {
            BankingExampleTheme { // Use your app's custom theme
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }

    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->
        // Apply the TVA grid background to the root of the layout
        GridBackground(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp) // Set padding for the sides
                    .padding(padding) // Scaffold padding
            ) {
                WalletSection()  // Ensure this is visible
                CardsSection()
                Spacer(modifier = Modifier.height(16.dp))
                FinanceSection()
                CurrenciesSection()
            }
        }
    }
}

@Composable
fun GridBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .background(Color(0xFF0D0D0D)) // Very dark background (almost black)
            .padding(4.dp) // Add padding for the outer border
            .border(4.dp, LightOrange, RoundedCornerShape(4.dp)) // Orange border around the grid
    ) {
        // Draw the grid lines with subtle colors
        Canvas(modifier = Modifier.fillMaxSize()) {
            val step = 30.dp.toPx() // Reduced grid line spacing to make the grid tighter

            for (x in 0..size.width.toInt() step step.toInt()) {
                drawLine(
                    color = Color(0xFF131313), // Darker and more subtle grid line color
                    start = androidx.compose.ui.geometry.Offset(x.toFloat(), 0f),
                    end = androidx.compose.ui.geometry.Offset(x.toFloat(), size.height),
                    strokeWidth = 0.8.dp.toPx() // Even thinner grid lines
                )
            }

            for (y in 0..size.height.toInt() step step.toInt()) {
                drawLine(
                    color = Color(0xFF131313), // Darker and more subtle grid line color
                    start = androidx.compose.ui.geometry.Offset(0f, y.toFloat()),
                    end = androidx.compose.ui.geometry.Offset(size.width, y.toFloat()),
                    strokeWidth = 0.8.dp.toPx() // Even thinner grid lines
                )
            }
        }
        content() // Your app content goes here
    }
}
