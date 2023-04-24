package com.pil.retrofit_room.database.mapper

import com.pil.retrofit_room.database.entity.ExerciseEntity
import com.pil.retrofit_room.service.model.Exercise

fun Exercise.mapToDataBaseExercise(): ExerciseEntity =
    ExerciseEntity(
        id = id,
        licenseAuthor = licenseAuthor,
        image = image,
        isMain = isMain,
        license = license,
    )

fun List<ExerciseEntity>.mapToLocalExercise(): List<Exercise> =
    map { entity ->
        Exercise(
            id = entity.id,
            licenseAuthor = entity.licenseAuthor,
            image = entity.image,
            isMain = entity.isMain,
            license = entity.license,
        )
    }
