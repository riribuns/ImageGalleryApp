package com.example.imagegalleryapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.imagegalleryapp.R

class FullScreenAdapter(var context: Context, var arraylist: MutableList<String>) : PagerAdapter() {
    override fun getCount(): Int {
        return arraylist.size

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view  == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.item_fullscreen, null)

        val imageView: ImageView = view.findViewById(R.id.imgView)

        Glide.with(context).load(arraylist[position]).into(imageView)
        val viewPager: ViewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager: ViewPager = container as ViewPager
        val view:View = `object` as View
        viewPager.removeView(view)

    }

}