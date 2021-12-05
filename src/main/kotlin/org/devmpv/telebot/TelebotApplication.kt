package org.devmpv.telebot

import org.devmpv.telebot.config.AppConfiguration
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = [AppConfiguration::class])
@ImportAutoConfiguration(AppConfiguration::class)
class TelebotApplication

fun main(args: Array<String>) {
    runApplication<TelebotApplication>(*args)
}
