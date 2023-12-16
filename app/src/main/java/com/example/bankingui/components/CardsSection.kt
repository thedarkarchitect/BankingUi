package com.example.bankingui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingui.R
import com.example.bankingui.ui.theme.Purple40
import com.example.bankingui.ui.theme.Purple80

data class Card(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val color: Brush,
)

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(Purple40, Purple80),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "367 7965 7786 2276",
        cardName = "Savings",
        balance = 48.67,
        color = getGradient(Color.Yellow, Color.Red),
    ),
    Card(
        cardType = "VISA",
        cardNumber = "0064 7865 3707 3976",
        cardName = "School",
        balance = 85.867,
        color = getGradient(Color.Green, Color.Magenta),
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "3657 7065 7775 2276",
        cardName = "Trips",
        balance = 267.67,
        color = getGradient(Color.Blue, Color.LightGray),
    ),

)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}

//@Preview(showBackground = true)
@Composable
fun CardsSection() {
    LazyRow{
        items(cards.size){ index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    
    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = image, contentDescription = card.cardName , modifier = Modifier.width(60.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}