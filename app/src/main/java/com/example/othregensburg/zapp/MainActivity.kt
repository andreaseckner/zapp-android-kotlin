package com.example.othregensburg.zapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG: String? = MainActivity::class.simpleName
        const val PUT_EXTRA_STRING = "text"
    }

    lateinit var editText: EditText
    private lateinit var helloWorldButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorldButton = findViewById(R.id.hello_world_button)
        editText = findViewById(R.id.activity_main_edit_text)

        helloWorldButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d(TAG, "Hello World!")
            }
        })
    }

    fun goToSecondActivity(view: View) {
        val text: String = editText.text.toString()

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(PUT_EXTRA_STRING, text)
        startActivity(intent)
    }
}
