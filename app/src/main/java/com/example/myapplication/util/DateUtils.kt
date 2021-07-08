package com.example.myapplication.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object DateUtils {
    const val DATE_TIME = "yyyy-MM-dd HH:mm:ss"
//    const val ZONED_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ssZ" // SimpleDateFormat
    const val ZONED_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss[XXX][X]" // DateTimeFormatter

    fun parse(
        datetime: String,
        pattern: String = DATE_TIME,
        locale: Locale = Locale.US
    ): LocalDateTime? {
        return try {
            val formatter = DateTimeFormatter.ofPattern(pattern, locale)
            LocalDateTime.parse(datetime, formatter)
        } catch (e: Exception) {
            null
        }
    }

    fun format(datetime: LocalDateTime, pattern: String, locale: Locale): String {
        return try {
            val formatter = DateTimeFormatter.ofPattern(pattern, locale)
            datetime.format(formatter)
        } catch (e: Exception) {
            ""
        }
    }

    fun getTotalMinutes(time: LocalDateTime): Int {
        return time.hour * 60 + time.minute + time.second / 60
    }

//    val resultOfParsing: OffsetDateTime =
//        OffsetDateTime.parse(text, DateTimeFormatter.ISO_DATE_TIME)
//    resultOfParsing.toLocalDateTime()
}