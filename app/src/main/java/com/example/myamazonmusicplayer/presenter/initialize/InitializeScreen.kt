package com.example.myamazonmusicplayer.presenter.initialize

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.myamazonmusicplayer.presenter.NavDestinationConst
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun InitializeScreen(
    navController: NavController,
    viewModel: InitializeViewModel
) {
    Text("初期化画面")

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Main) {
            val result = viewModel.getToken()
            Log.d("test", "result $result")
            when(result) {
                GetTokenResult.LOGIN -> navController.navigate(NavDestinationConst.LOGIN.route)
                GetTokenResult.HOME -> navController.navigate(NavDestinationConst.HOME.route)
                else -> Log.e("error", "nothing GetTokenResult")
            }

        }
    }
}