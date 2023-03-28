package com.example.othregensburg.zapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // TODO (3) Create a String constant TAG to store the name of the class
    // Hint: Kotlin does not have static variables. You could make use of a companion object.

    // TODO (4) Declare a property for the button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO (5) Assign the button from the layout to the class property

        // TODO (6) Create an anonymous OnClickListener and assign it to the button
        // TODO (7) Log a message with the given TAG property and String "Hello World"
    }
}
