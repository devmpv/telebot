package org.devmpv.telebot.utils.message

import org.devmpv.telebot.domain.weather.WeatherReport
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import java.time.format.DateTimeFormatter
import java.util.Locale

object CurrentWeatherMessageBuilder {

    private val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm:ss", Locale("ru"))

    fun toMessage(chatId: Long, weatherReport: WeatherReport?): SendMessage {
        val message = SendMessage()
        message.chatId = chatId.toString()
        message.parseMode = "MarkdownV2"
        message.text = weatherReport?.let {
            """
                    ```
                    Температура: ${it.current.temp} °C
                    Ощущается:   ${it.current.feelsLike} °C
                    Влажность:   ${it.current.humidity} %
                    Давление:    ${it.current.pressure} мм
                    Облачность:  ${it.current.clouds} %
                    Ветер:       ${it.current.wind_speed} м/c
                    Порывы:      ${it.current.wind_gust} м/c
                    ```
                    Данные на ${it.reportDateTime.format(formatter)}
                    """.trimIndent()
        }.orEmpty()
        return message
    }
}
