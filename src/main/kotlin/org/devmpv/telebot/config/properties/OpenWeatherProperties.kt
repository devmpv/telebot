package org.devmpv.telebot.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.Duration

@ConstructorBinding
@ConfigurationProperties("open-weather")
data class OpenWeatherProperties(
    val url: String,
    val appid: String,
    val defaultLocation: String,
    val latitude: Double,
    val longitude: Double,
    val updateInterval: Duration
)
