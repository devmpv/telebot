package org.devmpv.telebot.service

import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class UpdatePoller {
    private val logger = KotlinLogging.logger {}

    init {
        logger.info { "Initializing" }
    }
}
