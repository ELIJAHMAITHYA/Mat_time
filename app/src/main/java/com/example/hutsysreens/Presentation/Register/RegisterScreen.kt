package com.example.hutsysreens.Presentation.Register

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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hutsysreens.Components.MattimetextField
import com.example.hutsysreens.Components.RegisterButton
import com.example.hutsysreens.Components.headers
import com.example.hutsysreens.Components.mattimePassword
import com.example.hutsysreens.R
import com.example.hutsysreens.ui.theme.HutsySreensTheme

val defaultPadding = 16.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    onBackButtonClick:()-> Unit
) {
    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }
    val (firstName, setFirstName) = rememberSaveable {
        mutableStateOf("")
    }
    val (LASTName, setLastName) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (ConfirmPassword, setConfirmPassword) = rememberSaveable {
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
                    .align(Start)
                    .fillMaxWidth()
            ) {
                IconButton(onClick = onButtonClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "navigate Back"
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.smartphone),
                contentDescription = null
            )
            headers(text = "Create an Account")
            MattimetextField(
                onvalueChange = setFirstName,
                label = " First Name",
                value = firstName,
                leadingIcon = Icons.Filled.Person
            )
            Spacer(modifier = Modifier.height(4.dp))
            MattimetextField(
                onvalueChange = setLastName,
                label = " Last name",
                value =LASTName ,
                leadingIcon = Icons.Filled.Person
            )
            Spacer(modifier = Modifier.height(4.dp))
            MattimetextField(
                onvalueChange = setEmail,
                label = " Enter Email",
                value = email,
                leadingIcon = Icons.Filled.Email
            )
            Spacer(modifier = Modifier.height(defaultPadding))
            mattimePassword(
                onValueChange = setPassword,
                label = " Password",
                value = password,
                leadingIcon = Icons.Filled.Lock,
                onPassButtonClicked = { /*TODO*/ })
            Spacer(modifier = Modifier.height(defaultPadding))
            mattimePassword(
                onValueChange = setConfirmPassword,
                label = "Confirm Password",
                value = ConfirmPassword,
                leadingIcon = Icons.Filled.Lock,
                onPassButtonClicked = { /*TODO*/ })
            Spacer(modifier = Modifier.height(defaultPadding))
            RegisterButton(onButtonClicked = { }, content = "Register")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun RegScreenPreview() {
    HutsySreensTheme {
        RegisterScreen(onButtonClick = {}, onBackButtonClick = {})
    }
}