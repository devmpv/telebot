package org.devmpv.telebot.service

import mu.KotlinLogging
import org.devmpv.telebot.bot.DefaultBot
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Service
class BotRegistrationService(
    private val defaultBot: DefaultBot
) {
    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing bots" }

        try {
            val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
            botsApi.registerBot(defaultBot)
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}
