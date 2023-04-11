package com.example.othregensburg.zapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // TODO (4) Create a new class for the adapter which extends from RecyclerView.Adapter<ListAdapter.ViewHolder>
    // Follow the instructions from the exercise sheet or README

    private val randomValues =
        List(50) { ('A' + Random.nextInt('Z' - 'A')).toString() + " " + it.toString() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO (5) Find the RecyclerView defined in the layout and create a reference

        // TODO (6) Set a LayoutManager (LinearLayoutManager) to the RecyclerView

        // TODO (7) Set the newly created custom RecyclerView.Adapter to the RecyclerView
    }
}
