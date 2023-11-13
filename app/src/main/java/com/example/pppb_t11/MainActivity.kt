package com.example.pppb_t11

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pppb_t11.model.Articles
import com.example.pppb_t11.databinding.ActivityMainBinding
import com.example.pppb_t11.model.Data
import com.example.pppb_t11.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val client = ApiClient.getInstance()
        val response = client.getAllArticles()
        response.enqueue(object: Callback<Articles> {
            override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                val articles = ArrayList<Data>()
                for (i in response.body()!!.data) {
                    articles.add(Data(imageUrl = i.imageUrl, title = i.title, summary = i.summary, url = i.url))
                }
                val articleAdapter = ArticleAdapter(articles) {
                    article ->
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(article.url)
                    startActivity(intent)
                }
                with(binding) {
                    rvArticles.apply {
                        adapter = articleAdapter
                        layoutManager = GridLayoutManager(this@MainActivity, 2)
                    }
                }
            }

            override fun onFailure(call: Call<Articles>, t: Throwable) {

            }
        })
    }
}