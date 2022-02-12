package org.devmpv.telebot.bot

import mu.KotlinLogging
import org.devmpv.telebot.bot.commands.DailyCommand
import org.devmpv.telebot.bot.commands.HourlyCommand
import org.devmpv.telebot.bot.commands.WeatherCommand
import org.devmpv.telebot.config.properties.TelebotProperties
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Component
class WeatherBot(
    private val telebotProperties: TelebotProperties,
    private val weatherCommand: WeatherCommand,
    private val hourlyCommand: HourlyCommand,
    private val dailyCommand: DailyCommand
) : TelegramLongPollingCommandBot() {

    private val logger = KotlinLogging.logger {}

    init {
        register(weatherCommand)
        register(hourlyCommand)
        register(dailyCommand)

        logger.info { "Initializing bot named ${telebotProperties.auth.username}" }
    }

    override fun getBotToken() = telebotProperties.auth.token

    override fun getBotUsername() = telebotProperties.auth.username

    override fun processNonCommandUpdate(update: Update?) {
        if (update != null && update.hasMessage()) {
            reply(SendMessage(update.message.chatId.toString(), "UnknownCommand"))
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
