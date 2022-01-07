package org.devmpv.telebot.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("open-weather")
data class OpenWeatherProperties(
    val url: String,
    val appid: String
)