package org.devmpv.telebot.bot

import mu.KotlinLogging
import org.devmpv.telebot.client.OpenWeatherClient
import org.devmpv.telebot.config.TelebotProperties
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Component
class DefaultBot(
    private val telebotProperties: TelebotProperties,
    private val openWeatherClient: OpenWeatherClient
) : TelegramLongPollingBot() {

    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing bot named ${telebotProperties.auth.username}" }
    }

    override fun getBotToken() = telebotProperties.auth.token

    override fun getBotUsername() = telebotProperties.auth.username

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            val message = SendMessage()
            message.chatId = update.message.chatId.toString()
            if (update.message.document?.mimeType == "video/mp4") {
                message.text = "Video!"
            } else {
                message.text = "No video"
            }
            reply(message)
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
