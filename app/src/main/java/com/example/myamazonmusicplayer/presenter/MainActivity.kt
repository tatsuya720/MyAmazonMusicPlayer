package com.example.myamazonmusicplayer.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import com.example.myamazonmusicplayer.presenter.utils.LWAUtil
import com.example.myamazonmusicplayer.ui.theme.MyAmazonMusicPlayerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject lateinit var lwaUtil: LWAUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lwaUtil.initialize(activity = this)

        setContent {
            MyAmazonMusicPlayerTheme {
                AppNavHost()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        //lwaUtil.getToken(this)
    }

    override fun onResume() {
        super.onResume()
        lwaUtil.resume()
    }
}
