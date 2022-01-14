package org.devmpv.telebot.bot

import mu.KotlinLogging
import org.devmpv.telebot.config.properties.OpenWeatherProperties
import org.devmpv.telebot.config.properties.TelebotProperties
import org.devmpv.telebot.service.WeatherService
import org.devmpv.telebot.utils.message.CurrentWeatherMessageBuilder
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Component
class DefaultBot(
    private val telebotProperties: TelebotProperties,
    private val weatherService: WeatherService,
    private val weatherProperties: OpenWeatherProperties
) : TelegramLongPollingBot() {

    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing bot named ${telebotProperties.auth.username}" }
    }

    override fun getBotToken() = telebotProperties.auth.token

    override fun getBotUsername() = telebotProperties.auth.username

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            val weatherReport = weatherService.getCachedCurrentWeather(weatherProperties.defaultLocation)
            reply(CurrentWeatherMessageBuilder.toMessage(update.message.chatId, weatherReport))
        }
    }

    private fun reply(message: SendMessage) {
        try {
            execute(message)
        } catch (e: TelegramApiException) {
            logger.error(e) { "Something terrible happened when attempt to send message" }
        }
    }
}
