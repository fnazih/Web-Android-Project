/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val startButton = findViewById<Button>(R.id.buttonStart)

        startButton.setOnClickListener {
            System.out.println("Ca rentre dans setOnClickListener")
            val intent = Intent(this, ActivityMain::class.java)
            this.startActivity(intent)
        }
    }
}