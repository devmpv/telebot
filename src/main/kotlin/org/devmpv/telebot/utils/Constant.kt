package org.devmpv.telebot.utils

import java.time.format.DateTimeFormatter
import java.util.*

class Constant {
    companion object {
        const val HOURLY_ROW_FORMAT = "%1$-5s|%2$-7s|%3$-7s|%4\$-5s|%5\$-8s|%6\$-4s|%7\$-8s|%8\$-8s"
        const val DAILY_ROW_FORMAT = "%1$-8s|%2$-7s|%3$-7s|%4\$-5s|%5\$-8s|%6\$-4s|%7\$-8s|%8\$-8s"

        val DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm:ss", Locale("ru"))
        val HOUR_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:00", Locale("ru"))
        val DAY_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMM", Locale("ru"))
    }
}
