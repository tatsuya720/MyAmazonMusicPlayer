package com.example.myamazonmusicplayer.presenter.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myamazonmusicplayer.presenter.utils.LWAUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    app: Application,
    private val lwaUtil: LWAUtil,
): AndroidViewModel(app) {

    private val context
        get() = getApplication<Application>()

    fun login(successCallback: () -> Unit, failedCallback:() -> Unit) {
        lwaUtil.login(successCallback = successCallback, failedCallback = failedCallback)
    }

    fun resume() {
        lwaUtil.resume()
    }


}