package com.mnowo.secondcomposeuipractise

import android.database.sqlite.SQLiteTransactionListener
import android.os.Bundle
import android.os.TransactionTooLargeException
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mnowo.secondcomposeuipractise.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeUiPractiseTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(backgroundColor)
                ) {
                    TopAppBar()
                    Spacer(Modifier.padding(vertical = 10.dp))
                    YourBalanceRow()
                    Spacer(modifier = Modifier.padding(vertical = 20.dp))
                    CardRow()
                    Spacer(modifier = Modifier.padding(vertical = 15.dp))
                    Transaction()
                }
            }
        }
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 26.dp, end = 26.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(Icons.Filled.ArrowBack, contentDescription = "", tint = Color.White)
        Icon(Icons.Outlined.Notifications, contentDescription = "", tint = Color.White)
    }
}

@Composable
fun YourBalanceRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 26.dp)
    ) {
        Column {
            Text(
                text = "Your Balance",
                fontSize = 21.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Light,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(
                text = "$534,000.00",
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Composable
fun CardRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 26.dp, end = 26.dp)
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            backgroundColor = leftCardColor,
            contentColor = Color.Black,
            modifier = Modifier
                .height(170.dp)
                .width(150.dp)
        ) {
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                Icon(Icons.Filled.Share, contentDescription = "")
                Spacer(modifier = Modifier.padding(vertical = 15.dp))
                Text(
                    text = "$5600",
                    fontWeight = FontWeight.Normal,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Text(text = "Expense", fontWeight = FontWeight.Light, color = Color.Gray)
            }
        }
        Card(
            shape = RoundedCornerShape(10.dp),
            backgroundColor = rightCardColor,
            contentColor = Color.Black,
            modifier = Modifier
                .height(170.dp)
                .width(150.dp)
        ) {
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = "")
                Spacer(modifier = Modifier.padding(vertical = 15.dp))
                Text(
                    text = "$15,000",
                    fontWeight = FontWeight.Normal,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Text(text = "Spend to Goals", fontWeight = FontWeight.Light, color = Color.Gray)
            }
        }
    }
}

@Composable
fun Transaction() {
    Card(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            TransactionRow()
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            TransactionList()
        }
    }
}

@Composable
fun TransactionRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Transaction",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp
        )
        Card(
            shape = RoundedCornerShape(20.dp), backgroundColor = chipColor,
            modifier = Modifier
                .width(80.dp)
                .height(30.dp),
        ) {
            Text(
                text = "See All",
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = Color.Blue,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun TransactionListItem() {
    Row(
        Modifier
            .padding(start = 25.dp, end = 25.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            shape = CircleShape,
            backgroundColor = Color.Green,
            contentColor = Color.White,
            modifier = Modifier
                .height(60.dp)
                .width(60.dp)
        ) {
            Icon(Icons.Default.Home, contentDescription = "", Modifier.padding(7.dp))
        }
        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
        Column {
            Text(text = "House Purchase", fontWeight = FontWeight.Bold)
            Text(text = "Airbnb home", fontWeight = FontWeight.Light)
        }
        Text(
            text = "-$250",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp),
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun TransactionList() {
    LazyColumn {
        items(20) {
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            TransactionListItem()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SecondComposeUiPractiseTheme {
        TransactionListItem()
    }
}