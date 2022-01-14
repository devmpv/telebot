package org.devmpv.telebot.domain.weather

import java.time.ZonedDateTime

data class WeatherData(
    val dateTime: ZonedDateTime,
    val sunrise: ZonedDateTime?,
    val sunset: ZonedDateTime?,
    val temp: Double,
    val feelsLike: Double,
    val pressure: Double,
    val humidity: Int,
    val clouds: Int,
    val wind_speed: Double,
    val wind_gust: Double,
    val wind_deg: Int
)
