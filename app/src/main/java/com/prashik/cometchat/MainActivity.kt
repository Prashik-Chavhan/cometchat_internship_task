package com.prashik.cometchat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.cometchat.chat.core.CometChat
import com.cometchat.chat.exceptions.CometChatException
import com.cometchat.chat.models.User
import com.cometchat.chatuikit.shared.cometchatuikit.CometChatUIKit
import com.cometchat.chatuikit.shared.cometchatuikit.UIKitSettings

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    private val appId = BuildConfig.CometChat_AppId
    private val region = BuildConfig.CometChat_Region
    private val authKey = BuildConfig.CometChat_AuthKey

    private val uiKitSettings = UIKitSettings.UIKitSettingsBuilder()
        .setRegion(region)
        .setAppId(appId)
        .setAuthKey(authKey)
        .subscribePresenceForAllUsers()
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        CometChatUIKit.init(
            this,
            uiKitSettings,
            object : CometChat.CallbackListener<String?>() {
                override fun onSuccess(p0: String?) {
                    Log.d(TAG, "Initialization completed successful")
                    loginUser()
                }

                override fun onError(e: CometChatException?) {
                    Log.e(TAG, "Initialization failed: ${e?.message}")
                }
            }
        )
    }

    private fun loginUser() {
        CometChatUIKit.login(
            "cometchat-uid-1",
            object : CometChat.CallbackListener<User>() {
                override fun onSuccess(user: User?) {
                    Log.d("Login", "Login successful: ${user?.name}")

                    startActivity(Intent(this@MainActivity, ConversationActivity::class.java))
                }

                override fun onError(e: CometChatException?) {
                    Log.e("Login", "Login failed: ${e?.message}")
                }

            }
        )
    }
}