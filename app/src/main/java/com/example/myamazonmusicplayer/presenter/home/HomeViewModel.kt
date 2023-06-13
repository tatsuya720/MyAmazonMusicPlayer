package com.example.myamazonmusicplayer.presenter.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myamazonmusicplayer.presenter.utils.LWAUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    app: Application,
    private val lwaUtil: LWAUtil
) : AndroidViewModel(app){

    fun logout(successCallback: () -> Unit, failedCallback: () -> Unit) = lwaUtil.logout(getApplication<Application>().applicationContext, successCallback, failedCallback)

}