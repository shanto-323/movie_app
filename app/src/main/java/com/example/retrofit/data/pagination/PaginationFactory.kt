package com.example.retrofit.data.pagination

import retrofit2.Response

class PaginationFactory <Key,Item> (
    private val initialKey: Key,
    private inline val  onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> Response<Item>,
    private inline val getNextKey: suspend (Item) -> Key,
    private inline val onError: suspend (Throwable?) -> Unit,
    private inline val onSuccess: suspend (items:Item,newPage:Key) -> Unit,
){
    private var currentKey = initialKey // Page
    private var isMakingRequest = false


    suspend fun newPage() {
        if(isMakingRequest){
            return
        }
        isMakingRequest = true
        onLoadUpdated(true)
        try {
            val response = onRequest(currentKey)
            if(response.isSuccessful){
                isMakingRequest = false
                val item = response.body()!!
                currentKey = getNextKey(item)!!
                onSuccess(item,currentKey)
                onLoadUpdated(false)
            }
        }catch (e:Exception){
            onError(e)
            onLoadUpdated(false)
        }
    }

    fun reset() {
        currentKey = initialKey
    }
}