package org.devmpv.telebot.client.openweather

import org.devmpv.telebot.client.openweather.api.Exclude
import org.devmpv.telebot.client.openweather.api.OneCallResponse
import org.devmpv.telebot.client.openweather.api.Units
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "open-weather", url = "\${open-weather.url}")
interface OpenWeather {

    @GetMapping("onecall")
    fun oneCall(
        @RequestParam lat: Double,
        @RequestParam lon: Double,
        @RequestParam appid: String,
        @RequestParam exclude: Array<Exclude>? = arrayOf(Exclude.alerts),
        @RequestParam units: Units = Units.metric
    ): OneCallResponse?
}
