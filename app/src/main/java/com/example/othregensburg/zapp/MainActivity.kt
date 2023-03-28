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

    // TODO (3) Create a new Activity "SecondActivity" in the same package, (Hint: File -> New -> Activity -> Empty Activity)
    // TODO (4) Change the layout for the "SecondActivity" to show a TextView in the middle of the screen
    // TODO (5) Add a new property for the EditText field and bind the view from the layout (Hint: use findViewById in the onCreate method)

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

    // TODO (6) Add a method for the previously created button in the layout file
    // TODO (7) Get the value from the EditText field
    // TODO (8) Create an Intent to open the SecondActivity
    // TODO (9) Put the String from the EditText to the Intent (Hint: Intent#putExtra(name, value))
    // TODO (10) Start the SecondActivity
    // TODO (11) In the SecondActivity read the data from the Intent and show the String in the TextView

}
