package org.devmpv.telebot.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "open-weather", url = "\${open-weather.url}")
interface OpenWeather {

    @GetMapping("onecall")
    fun oneCall(
        @RequestParam lat: Double,
        @RequestParam lon: Double,
        @RequestParam appid: String
    ): String?
}