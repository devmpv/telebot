package org.devmpv.telebot.utils.message

import org.devmpv.telebot.domain.weather.WeatherReport
import org.devmpv.telebot.utils.Constant.Companion.DATE_TIME_FORMATTER
import org.devmpv.telebot.utils.Constant.Companion.HOURLY_ROW_FORMAT
import org.devmpv.telebot.utils.Constant.Companion.HOUR_FORMATTER
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

object WeatherHourlyForecastBuilder {

    fun toMessage(chatId: Long, weatherReport: WeatherReport?): SendMessage {
        val message = SendMessage()
        message.chatId = chatId.toString()
        message.parseMode = "MarkdownV2"
        val header = String.format(HOURLY_ROW_FORMAT, "Час", "Темп", "Ощущ.", "Влаж.", "Давл.", "Обл.", "Ветер", "Порывы")
        val reportText = header + "\n" + weatherReport?.hourly?.subList(0, 11)?.joinToString("\n") {
            String.format(
                HOURLY_ROW_FORMAT,
                it.dateTime.format(HOUR_FORMATTER),
                "${it.temp}°C",
                "${it.feelsLike}°C",
                "${it.humidity}%",
                "${it.pressure}мм",
                "${it.clouds}%",
                "${it.wind_speed}м/c",
                "${it.wind_gust}м/с"
            )
        }
        message.text = "```\n$reportText\n```\nДанные на ${weatherReport?.reportDateTime?.format(DATE_TIME_FORMATTER)}"
        return message
    }
}
