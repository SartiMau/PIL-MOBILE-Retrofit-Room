package com.pil.retrofit_room.mvvm.model

import com.pil.retrofit_room.database.ExerciseDataBase
import com.pil.retrofit_room.mvvm.contract.MainContract
import com.pil.retrofit_room.service.ExerciseService
import com.pil.retrofit_room.service.model.Exercise
import com.pil.retrofit_room.util.CoroutineResult

class MainModel(
    private val service: ExerciseService,
    private val database: ExerciseDataBase,
) : MainContract.Model {

    override suspend fun getExercises(): CoroutineResult<List<Exercise>> {
        return when (val exercises = service.getExercises()) {
            is CoroutineResult.Success -> {
                database.insertExercises(exercises.data.exercises)
                CoroutineResult.Success(database.getAllExercises())
            }

            is CoroutineResult.Failure -> {
                CoroutineResult.Success(database.getAllExercises())
            }
        }
    }
}
