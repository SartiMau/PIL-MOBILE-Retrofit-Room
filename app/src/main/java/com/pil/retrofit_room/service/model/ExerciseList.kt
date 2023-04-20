package com.pil.retrofit_room.service.model

import com.google.gson.annotations.SerializedName

data class ExerciseList(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: String,
    @SerializedName("results")
    var exercises: List<Exercise>,
)
