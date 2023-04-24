package com.pil.retrofit_room.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
class ExerciseEntity(
    @PrimaryKey var id: Int,
    var licenseAuthor: String,
    var image: String,
    var isMain: Boolean,
    var license: Int,
)
