package com.example.tmdb_api.Response

import com.example.tmdb_api.Model.PopularMovies_Model
import com.google.gson.annotations.SerializedName

class PopularMovies_Response {
    @SerializedName("results")
    var movieList = ArrayList<PopularMovies_Model>()
}
