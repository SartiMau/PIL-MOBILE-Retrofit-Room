package com.pil.retrofit_room.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.retrofit_room.service.model.ExerciseList
import com.pil.retrofit_room.mvvm.viewmodel.MainViewModel
import com.pil.retrofit_room.util.CoroutineResult
import kotlinx.coroutines.Job

interface MainContract {

    interface Model {
        fun getExercises(): CoroutineResult<ExerciseList>
    }

    interface ViewModel {
        fun getValue(): LiveData<MainViewModel.MainData>
        fun callService(): Job
    }
}
