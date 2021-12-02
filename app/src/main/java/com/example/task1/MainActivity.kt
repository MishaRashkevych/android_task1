package com.example.task1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorDetectorView = findViewById<TextView>(R.id.colorDetectorView)
        val redColourSelectorView = findViewById<TextView>(R.id.redColourSelectorView)
        val greenColourSelectorView = findViewById<TextView>(R.id.greenColourSelectorView)
        val yellowColourSelectorView = findViewById<TextView>(R.id.yellowColourSelectorView)

        val btnSwitchTheme = findViewById<Button>(R.id.btnSwitchTheme)
        val btnHindi = findViewById<Button>(R.id.btnHindi)
        val btnEnglish = findViewById<Button>(R.id.btnEnglish)

        redColourSelectorView.setOnClickListener {
            colorDetectorView.text = redColourSelectorView.background.toString()
            colorDetectorView.background = redColourSelectorView.background
        }

        yellowColourSelectorView.setOnClickListener {
            colorDetectorView.text = yellowColourSelectorView.background.toString()
            colorDetectorView.background = yellowColourSelectorView.background
        }

        greenColourSelectorView.setOnClickListener {
            colorDetectorView.text = greenColourSelectorView.background.toString()
            colorDetectorView.background = greenColourSelectorView.background
        }

        btnSwitchTheme.setOnClickListener {
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Configuration.UI_MODE_NIGHT_NO ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

        btnEnglish.setOnClickListener{
            val config = resources.configuration
            val locale = Locale("hi")
            Locale.setDefault(locale)
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }

        btnHindi.setOnClickListener{
            val config = resources.configuration
            val locale = Locale("hi")
            Locale.setDefault(locale)
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }
}