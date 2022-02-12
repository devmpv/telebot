package org.devmpv.telebot.utils.message

import org.devmpv.telebot.domain.weather.WeatherReport
import org.devmpv.telebot.utils.Constant.Companion.DATE_TIME_FORMATTER
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

object WeatherCurrentBuilder {

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
                    Данные на ${it.reportDateTime.format(DATE_TIME_FORMATTER)}
            """.trimIndent()
        }.orEmpty()
        return message
    }
}
