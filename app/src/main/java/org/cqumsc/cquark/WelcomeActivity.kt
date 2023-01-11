package org.cqumsc.cquark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val localIntent = Intent(this, LoginActivity::class.java)
        val timer = Timer()
        val test: TimerTask = object : TimerTask() {
            override fun run() {
                startActivity(localIntent)
            }
        }
        timer.schedule(test, 3000)
    }
}