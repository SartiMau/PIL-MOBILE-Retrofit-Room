package com.pil.retrofit_room.service

import com.pil.retrofit_room.service.model.ExerciseList
import com.pil.retrofit_room.util.CoroutineResult

interface ExerciseService {
    suspend fun getExercises(): CoroutineResult<ExerciseList>
}

class ExerciseServiceImpl(private val client: ExerciseClient) : ExerciseService {

    override suspend fun getExercises(): CoroutineResult<ExerciseList> {
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
