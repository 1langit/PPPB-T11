package com.example.pppb_t11

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pppb_t11.databinding.ItemArticleBinding
import com.example.pppb_t11.model.Data

typealias OnClickArticle = (Data) -> Unit

class ArticleAdapter(
    private val listArticle: List<Data>,
    private val onClickArticle: OnClickArticle
) : RecyclerView.Adapter<ArticleAdapter.ItemArticleViewHolder>() {

    inner class ItemArticleViewHolder(
        private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root
    ) {
        fun bind(data : Data) {
            with(binding) {
                Glide.with(root).load(data.imageUrl).override(Resources.getSystem().displayMetrics.widthPixels).centerCrop().into(imgArticle)
                txtTitle.text = data.title
                txtSummary.text = data.summary
                itemView.setOnClickListener {
                    onClickArticle(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listArticle.size
    }

    override fun onBindViewHolder(holder: ItemArticleViewHolder, position: Int) {
        holder.bind(listArticle[position])
    }
}