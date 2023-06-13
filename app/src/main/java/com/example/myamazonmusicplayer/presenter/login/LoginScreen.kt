package com.example.myamazonmusicplayer.presenter.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.myamazonmusicplayer.R
import com.example.myamazonmusicplayer.presenter.NavDestinationConst
import com.example.myamazonmusicplayer.ui.theme.MyAmazonMusicPlayerTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Button(
            onClick = {
                viewModel.login(successCallback = {
                    CoroutineScope(Dispatchers.Main).launch {
                        navController.navigate(NavDestinationConst.HOME.route)
                    }
                },
                failedCallback = {

                })
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.btnlwa_gold_loginwithamazon),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAmazonMusicPlayerTheme {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            )
        ) {
            Image(painter = painterResource(id = R.drawable.btnlwa_gold_loginwithamazon)
                , contentDescription = "")
        }
    }
}