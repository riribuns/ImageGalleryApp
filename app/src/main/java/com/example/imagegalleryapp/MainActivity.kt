package com.example.imagegalleryapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imagegalleryapp.adapters.GalleryAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)

        val images = mutableListOf<String>()

        for(i in 0 until 12) {
            images.add("https://picsum.photos/id/"+ Random.nextInt(59) + "/200/300")
        }

        val adapter = GalleryAdapter(this@MainActivity, images)
        recyclerView.adapter = adapter


    }
}