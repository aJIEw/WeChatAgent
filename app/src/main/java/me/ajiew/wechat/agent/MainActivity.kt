package me.ajiew.wechat.agent

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startWeChat()

        finish()
    }

    private fun startWeChat() {
        try {
            val weChatPackageName = "com.tencent.mm"
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.component = ComponentName(weChatPackageName, "com.tencent.mm.ui.LauncherUI")
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "WeChat is not found", LENGTH_SHORT).show();
        }
    }
}