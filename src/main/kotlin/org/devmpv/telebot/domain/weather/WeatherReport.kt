package org.devmpv.telebot.domain.weather

import java.time.ZonedDateTime

data class WeatherReport(
    val reportDateTime: ZonedDateTime,
    val current: WeatherData,
    val hourly: List<WeatherData>?,
    val daily: List<WeatherData>?
)
