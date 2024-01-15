package com.example.hutsysreens.Presentation.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hutsysreens.Components.MattimetextField
import com.example.hutsysreens.Components.RegisterButton
import com.example.hutsysreens.Components.forgotPasswordButton
import com.example.hutsysreens.Components.headers
import com.example.hutsysreens.Components.mattimePassword
import com.example.hutsysreens.Components.signUpButton
import com.example.hutsysreens.R
import com.example.hutsysreens.ui.theme.HutsySreensTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onForgetPasswordClick: () -> Unit,
    onSignUpButtonClick: () -> Unit
) {
    val defaultPadding = 16.dp
    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .height(180.dp),
                painter = painterResource(id = R.drawable.mattimeapp),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,

                )
            Spacer(modifier = Modifier.height(6.dp))
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopStart

            ) {
                headers(text = "Login")
            }

            Spacer(modifier = Modifier.height(defaultPadding))
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


            forgotPasswordButton(
                text = "Forgot Password",
                onForgetPasswordButtonClick = onForgetPasswordClick
            )

            Spacer(modifier = Modifier.height(20.dp))

            RegisterButton(
                onButtonClicked = onLoginClick,
                content = " Login"
            )
            Spacer(modifier = Modifier.height(defaultPadding))
            alternativeLogins()
            signUpButton(text = "Sign Up", onSignUpButtonClick = onSignUpButtonClick)
        }
    }
}

@Composable
fun alternativeLogins() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = " You can also sign in with ",
            style = typography.bodyMedium.copy(
                color = Color(0xFF436620)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Icon(

                painter = painterResource(id = R.drawable.facebook__2_), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { }
                    .clip(CircleShape)
            )
            Icon(
                painter = painterResource(id = R.drawable.github__1_), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { }
                    .clip(CircleShape)
            )
            Icon(
                painter = painterResource(id = R.drawable.google__2_), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { }
                    .clip(CircleShape)
            )
        }

    }
}

@Preview
@Composable
fun loginScreenPreview() {
    HutsySreensTheme {
        loginScreen(modifier = Modifier, {}, {}, {})
    }
}

//@Preview(showBackground = true)
//@Composable
//fun loginScreenPreview2() {
//    HutsySreensTheme {
//        alternativeLogins()
//    }
//}
