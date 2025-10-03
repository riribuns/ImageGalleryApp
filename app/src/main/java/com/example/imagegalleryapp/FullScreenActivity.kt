package com.example.imagegalleryapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import com.example.imagegalleryapp.adapters.FullScreenAdapter

class FullScreenActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)
        viewPager = findViewById(R.id.viewPager)

        val list = intent.getStringArrayListExtra("list")?.toMutableList() ?: mutableListOf()
        val position = intent.getIntExtra("position", 0)

        var adapter = FullScreenAdapter(this@FullScreenActivity, list)
        viewPager.adapter = adapter
        viewPager.currentItem = position

    }


}