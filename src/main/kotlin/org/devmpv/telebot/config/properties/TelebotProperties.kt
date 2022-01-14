package org.devmpv.telebot.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.telegram.telegrambots.bots.DefaultBotOptions

@ConstructorBinding
@ConfigurationProperties("telebot")
data class TelebotProperties(
    val auth: Auth,
    val defaultBotOptions: DefaultBotOptions?
) {
    data class Auth(
        val username: String = "",
        val token: String = ""
    )
}
