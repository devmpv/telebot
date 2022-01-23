package org.devmpv.telebot.bot.commands

enum class Commands(
    val identifier: String,
    val description: String
) {
    WEATHER("weather", "Get weather report")
}