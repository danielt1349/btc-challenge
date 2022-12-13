package com.mcontigo.test.utils

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

object DateUtil {
    fun getCurrentDateTimeWithTulFormat(str: String): LocalDateTime {
        // "Dec 12, 2022 05:56:00 UTC"
        return LocalDateTime.parse(
            str,
            DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss z", Locale.US).withZone(ZoneId.of("UTC"))
        )
    }
}
