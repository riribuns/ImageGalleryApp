package com.example.imagegalleryapp.adapters

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.R
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.imagegalleryapp.FullScreenActivity

class GalleryAdapter(var context: Context, var arrayList: MutableList<String>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(context).inflate(com.example.imagegalleryapp.R.layout.item_layout ,parent,false)
        return GalleryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val objLink = arrayList[position]
        Glide.with(holder.itemView).load(objLink)
                .listener(object: RequestListener<Drawable>{
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable?>, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable?>?, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                        holder.pb.visibility = View.GONE
                        return false
                    }

                }).into(holder.imageView)

    }
    inner class GalleryViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(com.example.imagegalleryapp.R.id.imgViewItem)
        val pb: ProgressBar = view.findViewById(com.example.imagegalleryapp.R.id.pbItem)

        init {
            imageView.setOnClickListener () {
                val intent = Intent(context, FullScreenActivity::class.java)
                intent.putStringArrayListExtra("list", ArrayList(arrayList))
                intent.putExtra("position", absoluteAdapterPosition)
                context.startActivity(intent)
            }
        }
    }
}