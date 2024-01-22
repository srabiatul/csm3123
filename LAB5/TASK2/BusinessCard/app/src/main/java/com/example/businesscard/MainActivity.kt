package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCardView()
                }
            }
        }
    }
}

@Composable
fun BusinessCardView() {
    val cardBackgroundColor = Color(0xFF073042)
    val textColor = Color.White
    val name = "Rabiatul binti Sulaiman"
    val jobTitle = "Student"
    val phoneNumber = "+6012-3456789"
    val social = "@hyyhrs"
    val email = "rs@gmail.com"

    Column(
        modifier = Modifier.fillMaxSize().background(cardBackgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(150.dp),
        )
        Text(
            text = name,
            color = textColor,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = jobTitle,
            color = Color(0xFFFBC02D),
            fontSize =20.sp
        )

        Divider(modifier = Modifier.fillMaxWidth(), thickness = 100.dp, color = Color(0xFF073042))

        ContactItem(R.drawable.phone, phoneNumber)
        ContactItem(R.drawable.ig, social)
        ContactItem(R.drawable.email, email)
    }
}

@Composable
fun ContactItem(iconResId: Int, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardView()
    }
}
