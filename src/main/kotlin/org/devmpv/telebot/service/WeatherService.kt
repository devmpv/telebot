package org.devmpv.telebot.service

import org.devmpv.telebot.config.properties.CacheProperties.CacheName.WEATHER_CURRENT
import org.devmpv.telebot.config.properties.OpenWeatherProperties
import org.devmpv.telebot.domain.weather.WeatherReport
import org.springframework.cache.annotation.Cacheable
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class WeatherService(
    private val weatherCacheService: WeatherCacheService,
    private val weatherProperties: OpenWeatherProperties
) {

    @Cacheable(cacheNames = [WEATHER_CURRENT.name], key = "#city")
    fun getCachedCurrentWeather(city: String): WeatherReport? {
        return null
    }

    @Scheduled(fixedDelayString = "\${open-weather.update-interval}")
    fun updateCurrentWeather() {
        weatherCacheService.updateCurrentWeather(weatherProperties.defaultLocation)
    }
}
