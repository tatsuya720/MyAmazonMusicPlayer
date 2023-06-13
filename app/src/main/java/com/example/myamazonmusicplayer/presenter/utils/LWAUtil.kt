package com.example.myamazonmusicplayer.presenter.utils

import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.amazon.identity.auth.device.AuthError
import com.amazon.identity.auth.device.api.Listener
import com.amazon.identity.auth.device.api.authorization.AuthCancellation
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager
import com.amazon.identity.auth.device.api.authorization.AuthorizeListener
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest
import com.amazon.identity.auth.device.api.authorization.AuthorizeResult
import com.amazon.identity.auth.device.api.authorization.ProfileScope
import com.amazon.identity.auth.device.api.workflow.RequestContext

class LWAUtil {
    private var requestContext: RequestContext? = null

    fun initialize(activity: FragmentActivity) {
        requestContext = RequestContext.create(activity)
    }

    fun login(successCallback: () -> Unit, failedCallback: () -> Unit) {
        requestContext?.let {
            it.registerListener(object : AuthorizeListener() {
                override fun onSuccess(p0: AuthorizeResult?) {
                    Log.d("test", "onsuccess")
                    successCallback.invoke()
                }

                override fun onError(p0: AuthError?) {
                    Log.d("test", "onError")
                    failedCallback.invoke()
                }

                override fun onCancel(p0: AuthCancellation?) {
                    Log.d("test", "onsCancel")
                }
            })
        }

        AuthorizationManager.authorize(
            AuthorizeRequest.Builder(requestContext)
                .addScopes(ProfileScope.profile(), ProfileScope.postalCode())
                .build()
        )
    }

    fun logout(context: Context, successCallback: () -> Unit, failedCallback: () -> Unit) {
        AuthorizationManager.signOut(context, object : Listener<Void?, AuthError?> {
            override fun onSuccess(p0: Void?) {
               successCallback.invoke()
            }

            override fun onError(authError: AuthError?) {
                Log.d("logoutError", authError?.message ?: "")
                failedCallback.invoke()
            }
        })
    }

    fun resume() {
        requestContext?.let {
            it.onResume()
        }
    }

    fun getToken(context: Context, loginCallback: () -> Unit, notLoginCallback: () -> Unit) {
        val scope = arrayOf(
            ProfileScope.profile(),
            ProfileScope.postalCode()
        )

        AuthorizationManager.getToken(context, scope, object : Listener<AuthorizeResult, AuthError > {
            override fun onSuccess(result: AuthorizeResult?) {
                if(result?.accessToken == null) {
                    Log.d("ログイン確認", "未ログイン")
                    notLoginCallback()
                } else {
                    Log.d("ログイン確認", "ログイン済み")
                    loginCallback()
                }
            }

            override fun onError(error: AuthError?) {
                Log.d("ログイン確認", "未ログイン")
                notLoginCallback()
            }
        })
    }
}