package com.example.hutsysreens.Components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hutsysreens.R
import com.example.hutsysreens.ui.theme.HutsySreensTheme
import org.w3c.dom.Text

@Composable
fun headers(
    modifier: Modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth(),
    text: String
) {
    Text(
        modifier = modifier
        ,
        text = text,
        style = MaterialTheme.typography.headlineMedium.copy(
            color = Color.Black,

        ),
        fontWeight = FontWeight.Bold,

        )
}

@Preview(showBackground = true)
@Composable
fun headerpreview() {
    HutsySreensTheme {
        headers(text = "Sign Up")
    }
}