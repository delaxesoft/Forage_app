package com.example.forageapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.forageapp.model.Forageable
import kotlinx.coroutines.flow.Flow

@Dao
interface ForageableDao {


    // TODO: implement a method to retrieve all Forageables from the database
    @Query("SELECT * FROM forageable")
    fun getForageables(): Flow<List<Forageable>>

  // TODO: implement a method to retrieve a Forageable from the database by id
  @Query("SELECT * FROM forageable WHERE id = :id")
  fun getForageable(id: Long): Flow<Forageable>


  //  implement a method to insert a Forageable into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(forageable: Forageable)

    @Update
    suspend fun update(forageable: Forageable)

    @Delete
    suspend fun delete(forageable: Forageable)
}
