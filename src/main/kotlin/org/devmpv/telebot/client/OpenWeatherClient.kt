package org.devmpv.telebot.client

import org.devmpv.telebot.config.OpenWeatherProperties
import org.springframework.stereotype.Component

@Component
class OpenWeatherClient(
    private val openWeather: OpenWeather,
    private val openWeatherProperties: OpenWeatherProperties
) {
    fun getWeatherResponse() : String? {
        return openWeather.oneCall(33.44, -94.04, openWeatherProperties.appid)
    }
}