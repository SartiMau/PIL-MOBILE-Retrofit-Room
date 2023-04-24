package com.pil.retrofit_room.database

import com.pil.retrofit_room.database.dao.ExerciseDao
import com.pil.retrofit_room.database.mapper.mapToDataBaseExercise
import com.pil.retrofit_room.database.mapper.mapToLocalExercise
import com.pil.retrofit_room.service.model.Exercise

interface ExerciseDataBase {
    suspend fun insertExercises(exercises: List<Exercise>)
    suspend fun getAllExercises(): List<Exercise>
}

class ExerciseDataBaseImpl(private val exerciseDao: ExerciseDao) : ExerciseDataBase {

    override suspend fun insertExercises(exercises: List<Exercise>) {
        exercises.forEach { exercise ->
            exerciseDao.insertExercise(exercise.mapToDataBaseExercise())
        }
    }

    override suspend fun getAllExercises(): List<Exercise> {
        return exerciseDao.getDBCharacters().mapToLocalExercise()
    }
}
