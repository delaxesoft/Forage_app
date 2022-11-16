package com.example.forageapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Forageable(
    @PrimaryKey(autoGenerate = true)val id: Long = 0,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="address")val address: String,

    @ColumnInfo(name="in-season") val inSeason: Boolean,
    @ColumnInfo(name = "notes") val notes: String?
)

