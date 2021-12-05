package org.devmpv.telebot.service

import mu.KotlinLogging
import org.devmpv.telebot.config.TelebotProperties
import org.springframework.stereotype.Service

@Service
class UpdatePoller(
    private val telebotProperties: TelebotProperties
) {
    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing" }
    }
}
