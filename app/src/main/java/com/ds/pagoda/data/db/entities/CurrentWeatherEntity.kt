package com.ds.pagoda.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_weather")
data class CurrentWeatherEntity (

    @PrimaryKey
    var id: Int,

    @ColumnInfo(name = "main") var main: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "temp") var temp: Double?,
    @ColumnInfo(name = "wind") var windSpeed: Double?,
    @ColumnInfo(name = "deg") var windDeg: Double?,
    @ColumnInfo(name = "sunset") var sunset: Double?,
    @ColumnInfo(name = "name") var name: Double?,
    @ColumnInfo(name = "dt") var dateTime: Double?

)
