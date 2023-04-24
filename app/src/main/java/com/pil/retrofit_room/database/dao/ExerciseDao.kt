package com.pil.retrofit_room.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pil.retrofit_room.database.entity.ExerciseEntity

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExercise(binEntity: ExerciseEntity): Long

    @Query("SELECT * FROM exercise")
    fun getDBCharacters(): List<ExerciseEntity>
}
