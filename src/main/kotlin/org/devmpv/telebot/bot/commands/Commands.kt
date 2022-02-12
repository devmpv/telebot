package org.devmpv.telebot.bot.commands

enum class Commands(
    val identifier: String,
    val description: String
) {
    WEATHER("weather", "Current weather report"),
    HOURLY("hourly", "Hourly weather forecast"),
    DAYLY("daily", "Daily weather forecast")
}