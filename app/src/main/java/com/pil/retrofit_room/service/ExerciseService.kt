package com.pil.retrofit_room.service

import com.pil.retrofit_room.service.model.ExerciseList
import com.pil.retrofit_room.util.CoroutineResult
import java.lang.Exception

class ExerciseService(private val client: ExerciseClient) {

    fun getExercises(): CoroutineResult<ExerciseList> {
        try {
            val response = client.getData().execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    return CoroutineResult.Success(it)
                }
            }
            return CoroutineResult.Failure(Exception(response.errorBody().toString()))
        } catch (e: Exception) {
            return CoroutineResult.Failure(e)
        }
    }
}
