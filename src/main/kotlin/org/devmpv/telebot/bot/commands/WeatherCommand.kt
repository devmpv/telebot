package org.devmpv.telebot.bot.commands

import mu.KotlinLogging
import org.devmpv.telebot.config.properties.OpenWeatherProperties
import org.devmpv.telebot.service.WeatherService
import org.devmpv.telebot.utils.message.WeatherCurrentBuilder
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Component
class WeatherCommand(
    private val weatherService: WeatherService,
    private val weatherProperties: OpenWeatherProperties
) : BotCommand(Commands.WEATHER.identifier, Commands.WEATHER.description) {

    private val logger = KotlinLogging.logger {}

    override fun execute(absSender: AbsSender, user: User?, chat: Chat, strings: Array<out String>?) {
        val weatherReport = weatherService.getCachedCurrentWeather(weatherProperties.defaultLocation)
        try {
            absSender.execute(WeatherCurrentBuilder.toMessage(chat.id, weatherReport))
        } catch (e: TelegramApiException) {
            logger.error(e) { "Something terrible happened when attempt to send message" }
        }
    }
}
