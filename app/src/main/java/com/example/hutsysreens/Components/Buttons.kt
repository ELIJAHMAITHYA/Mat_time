package com.example.hutsysreens.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hutsysreens.ui.theme.HutsySreensTheme

@Composable
fun RegisterButton(
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF528122),
        contentColor = Color.White
    ),
    content: String,

    ) {
    Button(
        onClick = onButtonClicked,
        modifier = modifier.fillMaxWidth(),
        colors = colors,
        shape = MaterialTheme.shapes.large
    ) {
        Text(
            text = content,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight(600)
            )
        )
    }
}

@Composable
fun forgotPasswordButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = Color(0xFF528122)
    ),
    onForgetPasswordButtonClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        TextButton(
            onClick = onForgetPasswordButtonClick,
            colors = colors,
            modifier = modifier,
            shape = MaterialTheme.shapes.large
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color(0xFF528122)
                ),
                modifier = modifier
                    .padding(vertical = 2.dp)
                    .drawBehind {
                        drawLine(
                            color = Color(0xFF55611B),
                            strokeWidth = 2.dp.toPx(),
                            start = Offset(0f, size.height - 2.sp.toPx()),
                            end = Offset(size.width, size.height - 2.sp.toPx()),
                        )
                    }

            )
        }
    }
}


@Composable
fun signUpButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = Color(0xFF528122)
    ),
    onSignUpButtonClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        TextButton(
            onClick = onSignUpButtonClick,
            colors = colors,
            modifier = modifier,
            shape = MaterialTheme.shapes.large
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color(0xFF528122)
                ),
                modifier = modifier
                    .padding(vertical = 2.dp)
                    .drawBehind {
                        drawLine(
                            color = Color(0xFF55611B),
                            strokeWidth = 2.dp.toPx(),
                            start = Offset(0f, size.height - 2.sp.toPx()),
                            end = Offset(size.width, size.height - 2.sp.toPx()),
                        )
                    }

            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun previewRegister() {
    HutsySreensTheme {
        RegisterButton(
            onButtonClicked = { },
            modifier = Modifier.padding(20.dp),
            content = "Register"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun forgotPassPreview() {
    HutsySreensTheme {
        forgotPasswordButton(text = "Forgot Password") {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun signUpPreview() {
    HutsySreensTheme {
        signUpButton(text = "SignUp") {
        }
    }
}



