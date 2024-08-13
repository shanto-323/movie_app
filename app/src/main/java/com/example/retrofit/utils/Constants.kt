package com.example.retrofit.utils

object Constants {


    const val ITEM_INDEX = "itemIndex"
    const val MOVIE_ID = "movieId"

    //API ITEMS
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val POSTER_URL = "https://image.tmdb.org/t/p/original/"
    const val API_KEY = "6747ed637b5f45740447021afdfa2c14"

    //movie genre
    const val MOVIE_TYPE_POPULAR = "popular"
    const val MOVIE_TYPE_TOP_RATED = "top_rated"
    const val MOVIE_TYPE_UPCOMING = "upcoming"


    //SCREENS
    const val SCREEN = "screen"
    const val SEARCH_SCREEN = "search_screen"
    const val MAIN_SCREEN = "main_screen"
    const val DETAIL_ITEM_SCREEN = "detail_item_screen/{$ITEM_INDEX}"
    const val VIDEO_SCREEN = "video_screen/{$MOVIE_ID}"

    //VidSrc url
    const val VIDEO_LINK = "https://vidsrc.xyz/embed/movie/"
}
