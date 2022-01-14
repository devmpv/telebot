package org.devmpv.telebot.service

import mu.KotlinLogging
import org.devmpv.telebot.client.openweather.OpenWeatherClient
import org.devmpv.telebot.config.properties.CacheProperties
import org.devmpv.telebot.domain.weather.WeatherReport
import org.devmpv.telebot.utils.toWeatherReport
import org.springframework.cache.annotation.CachePut
import org.springframework.stereotype.Service

@Service
class WeatherCacheService(
    private val openWeatherClient: OpenWeatherClient
) {
    private val logger = KotlinLogging.logger {}

    @CachePut(cacheNames = [CacheProperties.CacheName.WEATHER_CURRENT.name], key = "#city")
    fun updateCurrentWeather(city: String): WeatherReport? {
        val report = openWeatherClient.getOneCallResponse()?.toWeatherReport()
        logger.debug { "Updating weather cache for $city. Report=$report" }
        return report
    }
}
