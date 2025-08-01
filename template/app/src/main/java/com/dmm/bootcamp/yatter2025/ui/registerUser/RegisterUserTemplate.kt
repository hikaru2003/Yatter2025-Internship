package com.dmm.bootcamp.yatter2025.ui.registerUser

import android.graphics.Outline
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmm.bootcamp.yatter2025.domain.model.Username
import com.dmm.bootcamp.yatter2025.ui.theme.Yatter2025Theme

@Composable
fun RegisterUserTemplate(
    userName: String,
    onChangeUsername: (String) -> Unit,
    password: String,
    onChangePassword: (String) -> Unit,
    isEnableRegister: Boolean,
    isLoading: Boolean,
    onClickRegister: () -> Unit,
    onClickCancel: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "新規ユーザー登録")
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .padding(8.dp),
            contentAlignment = Alignment.Center,
            ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 16.dp),
                    text = "ユーザー名"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = userName,
                    onValueChange = onChangeUsername,
                    placeholder = {
                        Text(text = "username")
                    },
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "パスワード"
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = password,
                    onValueChange = onChangePassword,
                    placeholder = {
                        Text(text = "password")
                    },
                )

                Button(
                    enabled = isEnableRegister,
                    onClick = onClickRegister,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = "登録")
                }
            }
            if (isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}

@Preview
@Composable
private fun RegisterUserTemplatePreview() {
    Yatter2025Theme {
        Surface {
            RegisterUserTemplate(
                userName = "username",
                onChangeUsername = {},
                password = "password",
                onChangePassword = {},
                isEnableRegister = true,
                isLoading = false,
                onClickRegister = {},
                onClickCancel = {},
            )
        }
    }
}