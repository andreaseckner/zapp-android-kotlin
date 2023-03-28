package com.example.othregensburg.zapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG: String? = MainActivity::class.simpleName
    }

    private lateinit var helloWorldButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorldButton = findViewById(R.id.hello_world_button)

        helloWorldButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d(TAG, "Hello World!")
            }
        })
    }
}
