package com.example.othregensburg.zapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.tv_second_activity)

        val text = intent.extras?.get(MainActivity.PUT_EXTRA_STRING) as CharSequence?

        textView.text = text
    }
}
