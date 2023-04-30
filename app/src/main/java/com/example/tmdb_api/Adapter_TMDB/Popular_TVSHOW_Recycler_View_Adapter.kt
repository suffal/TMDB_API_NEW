package com.example.tmdb_api.Adapter_TMDB

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_api.Model.Popular_TVSHOW_Model
import com.example.tmdb_api.R
import com.example.tmdb_api.databinding.PopularPersonLayoutBinding


class Popular_TVSHOW_Recycler_View_Adapter(
    private val personlist: List<Popular_TVSHOW_Model>,
    private var context: Context
) : RecyclerView.Adapter<Popular_TVSHOW_Recycler_View_Adapter.PersonDataViewHolder>() {

    inner class PersonDataViewHolder(var binding: PopularPersonLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonDataViewHolder {
        val view: View? = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_person_layout, parent, false)
        val binding: PopularPersonLayoutBinding = DataBindingUtil.bind(view!!)!!
        return PersonDataViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return personlist.size
    }
    override fun onBindViewHolder(holder: PersonDataViewHolder, position: Int) {
        val person = personlist[position]

        holder.binding.apply {
            var personImageurl = person.poster_path
            var movietitle = person.original_name
            val urlpath = "https://image.tmdb.org/t/p/w500//${personImageurl}"
            personTextView.text = movietitle
            Glide.with(context).load(urlpath).into(personImageView)
        }
    }
}