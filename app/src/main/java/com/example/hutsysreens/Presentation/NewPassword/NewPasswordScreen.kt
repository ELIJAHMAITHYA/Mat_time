package com.example.hutsysreens.Presentation.NewPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hutsysreens.Components.MattimetextField
import com.example.hutsysreens.Components.RegisterButton
import com.example.hutsysreens.R
import com.example.hutsysreens.ui.theme.HutsySreensTheme


val defaultPadding = 16.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newPasswordScreen(
    modifier: Modifier,
    onClick: () -> Unit,
    onBackButtonClicl: () -> Unit
) {
    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (newPassword, setNewPassword) = rememberSaveable {
        mutableStateOf("")
    }
    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
            ) {
                IconButton(onClick = onBackButtonClicl) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "navigate Back"
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Reset Password",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                modifier = modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(defaultPadding))
            Text(
                text = "Reset your password by creating new one",
                style = MaterialTheme.typography.bodyMedium.copy(
                ),
                modifier = modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(defaultPadding))
            MattimetextField(
                onvalueChange = setPassword,
                label = "New Password",
                value = password,
            )
            Spacer(modifier = Modifier.height(defaultPadding))
            MattimetextField(
                onvalueChange = setNewPassword,
                label = "Confirm Password",
                value = newPassword,
            )
            Spacer(modifier = Modifier.height(defaultPadding))

            RegisterButton(onButtonClicked = onClick, content = "Reset Password")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun fpPreview() {
    HutsySreensTheme {
        newPasswordScreen(modifier = Modifier, onClick = { /*TODO*/ }) {

        }
    }
}