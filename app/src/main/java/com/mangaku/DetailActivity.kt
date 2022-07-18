package com.mangaku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mangaku.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_MANGA = "extra_manga"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manga = intent.getParcelableExtra<Manga>(EXTRA_MANGA)
        if (manga != null) {
            with(binding) {
                tvTitle.text = manga.title
                tvAuthor.text = manga.author.uppercase()
                tvGenre.text = manga.genre
                tvSummary.text = "\u3000\u3000" + manga.summary
                ivManga.setImageResource(manga.avatar)
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail"
    }
}