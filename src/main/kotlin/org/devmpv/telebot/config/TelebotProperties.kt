package org.devmpv.telebot.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("telebot")
data class TelebotProperties(
    val auth: Auth
) {
    data class Auth(
        val username: String? = null,
        val token: String? = null
    )
}