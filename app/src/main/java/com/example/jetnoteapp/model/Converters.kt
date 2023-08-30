package com.example.jetnoteapp.model

import androidx.room.TypeConverter
import java.time.Instant
import java.util.Date
import java.util.UUID

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toUUID(uuidString: String): UUID {
        return UUID.fromString(uuidString)
    }

    @TypeConverter
    @JvmStatic
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    @JvmStatic
    fun toDate(timestamp: Long): Date {
        return Date(timestamp)
    }
}
