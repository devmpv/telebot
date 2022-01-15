package org.devmpv.telebot.utils

import org.devmpv.telebot.client.openweather.api.data.Current
import org.devmpv.telebot.client.openweather.api.data.Daily
import org.devmpv.telebot.client.openweather.api.data.Hourly
import org.devmpv.telebot.client.openweather.api.OneCallResponse
import org.devmpv.telebot.domain.weather.WeatherData
import org.devmpv.telebot.domain.weather.WeatherReport
import java.math.RoundingMode
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

const val PASCAL_IN_MHG: Double = 0.75006150504341

fun Double.toMhg() = (this * PASCAL_IN_MHG).toBigDecimal().setScale(1, RoundingMode.HALF_UP).toDouble()

fun OneCallResponse.toWeatherReport() = WeatherReport(
    reportDateTime = ZonedDateTime.ofInstant(
        Instant.ofEpochSecond(this.current!!.dt),
        ZoneOffset.ofTotalSeconds(this.timezone_offset!!).normalized()
    ),
    current = this.current.toWeatherData(ZoneOffset.ofTotalSeconds(this.timezone_offset).normalized()),
    hourly = this.hourly?.map { it ->
        it.toWeatherData(ZoneOffset.ofTotalSeconds(this.timezone_offset).normalized())
    },
    daily = this.daily?.map { it ->
        it.toWeatherData(ZoneOffset.ofTotalSeconds(this.timezone_offset).normalized())
    }
)

fun Hourly.toWeatherData(zoneId: ZoneId) = WeatherData(
    dateTime = ZonedDateTime.ofInstant(Instant.ofEpochSecond(this.dt), zoneId),
    sunrise = null,
    sunset = null,
    temp = this.temp,
    feelsLike = this.feels_like,
    pressure = this.pressure.toMhg(),
    humidity = this.humidity,
    clouds = this.clouds,
    wind_speed = this.wind_speed,
    wind_gust = this.wind_gust,
    wind_deg = this.wind_deg
)

fun Daily.toWeatherData(zoneId: ZoneId) = WeatherData(
    dateTime = ZonedDateTime.ofInstant(Instant.ofEpochSecond(this.dt), zoneId),
    sunrise = null,
    sunset = null,
    temp = this.temp.day,
    feelsLike = this.feels_like.day,
    pressure = this.pressure.toMhg(),
    humidity = this.humidity,
    clouds = this.clouds,
    wind_speed = this.wind_speed,
    wind_gust = this.wind_gust,
    wind_deg = this.wind_deg
)

fun Current.toWeatherData(zoneId: ZoneId) = WeatherData(
    dateTime = ZonedDateTime.ofInstant(Instant.ofEpochSecond(this.dt), zoneId),
    sunrise = ZonedDateTime.ofInstant(Instant.ofEpochSecond(this.sunrise), zoneId),
    sunset = ZonedDateTime.ofInstant(Instant.ofEpochSecond(this.sunset), zoneId),
    temp = this.temp,
    feelsLike = this.feels_like,
    pressure = this.pressure.toMhg(),
    humidity = this.humidity,
    clouds = this.clouds,
    wind_speed = this.wind_speed,
    wind_gust = this.wind_gust,
    wind_deg = this.wind_deg
)
