package com.example.myamazonmusicplayer.presenter.initialize

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myamazonmusicplayer.presenter.utils.LWAUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject


enum class GetTokenResult {
    WAIT,
    LOGIN,
    HOME,
}

@HiltViewModel
class InitializeViewModel @Inject constructor(
    app: Application,
    private val lwaUtil: LWAUtil
): AndroidViewModel(app) {

    suspend fun getToken(): GetTokenResult {
        var result: GetTokenResult = GetTokenResult.WAIT
        lwaUtil.getToken(getApplication(),
            loginCallback = {
                result = GetTokenResult.HOME
            },
            notLoginCallback = {
                result = GetTokenResult.LOGIN
            }
        )

        while(result == GetTokenResult.WAIT) {
            delay(500)
        }

        return result
    }

}