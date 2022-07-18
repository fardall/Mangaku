package com.mangaku

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mangaku.databinding.ItemMangaBinding

class MangaAdapter : RecyclerView.Adapter<MangaAdapter.ViewHolder>() {
    private val listManga = ArrayList<Manga>()

    fun setListManga(list: List<Manga>) {
        listManga.clear()
        listManga.addAll(list)
    }

    class ViewHolder(private val binding: ItemMangaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(manga: Manga) {
            with(binding) {
                tvTitle.text = manga.title
                ivManga.setImageResource(manga.avatar)
                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MANGA, manga)
                    it.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaAdapter.ViewHolder {
        val binding = ItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MangaAdapter.ViewHolder, position: Int) {
        holder.bind(listManga[position])
    }

    override fun getItemCount(): Int {
        return listManga.size
    }


}