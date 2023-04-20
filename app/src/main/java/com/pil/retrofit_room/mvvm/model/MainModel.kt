package com.pil.retrofit_room.mvvm.model

import com.pil.retrofit_room.mvvm.contract.MainContract
import com.pil.retrofit_room.service.ExerciseService
import com.pil.retrofit_room.service.model.ExerciseList
import com.pil.retrofit_room.util.CoroutineResult

class MainModel(private val service: ExerciseService) : MainContract.Model {

    override fun getExercises(): CoroutineResult<ExerciseList> {
        val exercises = service.getExercises()
        // TODO: save exercises into a Room DataBase
        // TODO: get and return exercises from the Room DataBase
        return exercises

        // TODO: What happens if the service fails?
    }
}
