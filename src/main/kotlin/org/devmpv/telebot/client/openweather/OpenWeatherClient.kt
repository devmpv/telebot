package org.devmpv.telebot.client.openweather

import feign.FeignException
import mu.KotlinLogging
import org.devmpv.telebot.client.openweather.api.Exclude
import org.devmpv.telebot.client.openweather.api.OneCallResponse
import org.devmpv.telebot.config.properties.OpenWeatherProperties
import org.springframework.stereotype.Component

@Component
class OpenWeatherClient(
    private val openWeather: OpenWeather,
    private val openWeatherProperties: OpenWeatherProperties
) {
    private val logger = KotlinLogging.logger {}

    fun getOneCallResponse() : OneCallResponse? {
        try {
            return openWeather.oneCall(
                lat = openWeatherProperties.latitude,
                lon = openWeatherProperties.longitude,
                appid = openWeatherProperties.appid,
                exclude = arrayOf(Exclude.alerts, Exclude.minutely)
            )
        } catch (e: FeignException) {
            logger.error(e) { "Unable to get weather response" }
        }
        return null
    }
}
