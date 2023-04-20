package com.pil.retrofit_room.service

import com.pil.retrofit_room.service.model.ExerciseList
import retrofit2.Call
import retrofit2.http.GET

interface ExerciseClient {
    @GET("/api/v2/exerciseimage/")
    fun getData(): Call<ExerciseList>
}
