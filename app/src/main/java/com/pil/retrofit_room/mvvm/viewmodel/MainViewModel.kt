package com.pil.retrofit_room.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pil.retrofit_room.mvvm.contract.MainContract
import com.pil.retrofit_room.service.model.Exercise
import com.pil.retrofit_room.util.CoroutineResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val model: MainContract.Model) : ViewModel(), MainContract.ViewModel {

    private val mutableLiveData: MutableLiveData<MainData> = MutableLiveData()
    override fun getValue(): LiveData<MainData> = mutableLiveData

    override fun callService() = viewModelScope.launch {
        withContext(Dispatchers.IO) { model.getExercises() }.let { result ->
            when (result) {
                is CoroutineResult.Success -> {
                    mutableLiveData.value = MainData(MainStatus.SHOW_INFO, result.data.exercises)
                }
                is CoroutineResult.Failure -> {
                }
            }
        }
    }

    data class MainData(
        val status: MainStatus,
        val exercises: List<Exercise>,
    )

    enum class MainStatus {
        SHOW_INFO,
    }
}
