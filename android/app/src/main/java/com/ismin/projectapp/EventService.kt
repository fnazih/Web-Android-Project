package com.ismin.projectapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface EventService {
    @GET("events")
    fun getAllEventsSortedByTitle(): Call<ArrayList<Event>>

    @GET("events/{id}")
    fun getEvent(@Path("id") eventId: String): Call<Event>

    @PUT("events/{id}")
    fun addToFav(@Path("id") eventId: String, @Body() favBody: FavBody): Call<Event>
}