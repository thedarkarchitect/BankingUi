package com.example.bankingui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingui.components.BottomNavigationBar
import com.example.bankingui.components.CardsSection
import com.example.bankingui.components.CurrenciesSection
import com.example.bankingui.components.FinanceSection
import com.example.bankingui.components.WalletSection
import com.example.bankingui.ui.theme.BankingUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    HomeScreen()

                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            WalletSection()
            CardsSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()
            CurrenciesSection()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BankingUiTheme {
        HomeScreen()
    }
}
