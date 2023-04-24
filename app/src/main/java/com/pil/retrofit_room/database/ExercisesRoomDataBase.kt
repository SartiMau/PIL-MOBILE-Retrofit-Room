package com.pil.retrofit_room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pil.retrofit_room.database.dao.ExerciseDao
import com.pil.retrofit_room.database.entity.ExerciseEntity

@Database(
    entities = [
        ExerciseEntity::class,
    ],
    version = 1,
)
abstract class ExercisesRoomDataBase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
}
