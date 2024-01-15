package com.example.hutsysreens.Components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hutsysreens.R
import com.example.hutsysreens.ui.theme.HutsySreensTheme
import java.lang.reflect.Type

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MattimetextField(
    modifier: Modifier = Modifier,
    onvalueChange: (String) -> Unit,
    label: String,
    value : String,
    leadingIcon: ImageVector? = null,
    colors: TextFieldColors = outlinedTextFieldColors(
        focusedBorderColor = Color(0xFF4CC917),
        unfocusedBorderColor = Color(0xFF44666B)
    )
) {
    OutlinedTextField(
        value =value,
        modifier = modifier.fillMaxWidth(),
        onValueChange = onvalueChange,
        colors = colors,
        shape = MaterialTheme.shapes.large,
        label = {
            Text(
                text = label,
                style = typography.bodyMedium.copy(
                    color = Color(0xFF436620)
                )
            )
        },
        leadingIcon = {
            if (leadingIcon != null) androidx.compose.material3.Icon(
                imageVector = leadingIcon,
                contentDescription = null
            )
        },

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mattimePassword(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    label: String,
    value: String,
    leadingIcon: ImageVector? = null,
    colors: TextFieldColors = outlinedTextFieldColors(
        focusedBorderColor = Color(0xFF4CC917),
        unfocusedBorderColor = Color(0xFF44666B)
    ),
    onPassButtonClicked: () -> Unit,
    passwordVisible: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        colors = colors,
        shape = MaterialTheme.shapes.large,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        placeholder = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF436620)
                )
            )
        },
        leadingIcon = {
            if (leadingIcon != null) {
                androidx.compose.material3.Icon(
                    imageVector = leadingIcon,
                    contentDescription = null
                )
            }
        },
        trailingIcon = {
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { onPassButtonClicked() } // Use interactionSource here
            ) {
                Icon(
                    painter = painterResource(id = if (passwordVisible) R.drawable.hide else R.drawable.eye),
                    contentDescription = null,
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun textfieldPreview() {
    HutsySreensTheme {
        MattimetextField(
            onvalueChange = {},
            value = "",
            label = "Username",
            modifier = Modifier.padding(16.dp),
            leadingIcon = Icons.Filled.Person
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PassPreview() {
    HutsySreensTheme {
        mattimePassword(
            value = "",
            onValueChange = {},
            modifier = Modifier.padding(16.dp),
            label = " Enter Password",
            leadingIcon = Icons.Filled.Lock,
            onPassButtonClicked = { })
    }
}