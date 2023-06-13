package com.example.myamazonmusicplayer.presenter.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myamazonmusicplayer.presenter.NavDestinationConst
import com.example.myamazonmusicplayer.ui.theme.MyAmazonMusicPlayerTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel,
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoutButton {
                viewModel.logout(
                    successCallback = {
                        CoroutineScope(Dispatchers.Main).launch {
                            navController.navigate(NavDestinationConst.LOGIN.route)
                        }
                    },
                    failedCallback = {

                    }
                )
            }
        }

//        Button(
//            onClick = {
//                viewModel.logout()
//            },
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color.Transparent,
//            )
//        ) {
//            Text("ログアウト")
//        }
    }
}

@Composable
fun LogoutButton(
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.width(300.dp).height(60.dp),
        onClick = onClick,
    ) {
        Text("ログアウト")
    }

}

@Preview
@Composable
fun PreviewLogoutButton() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            LogoutButton {

            }
        }

    }
}