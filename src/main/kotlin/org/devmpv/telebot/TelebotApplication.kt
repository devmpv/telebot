package org.devmpv.telebot

import org.devmpv.telebot.config.AppConfiguration
import org.devmpv.telebot.config.ConfigPackageMarker
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ImportAutoConfiguration(AppConfiguration::class)
@ConfigurationPropertiesScan(basePackageClasses = [ConfigPackageMarker::class])
class TelebotApplication

fun main(args: Array<String>) {
    runApplication<TelebotApplication>(*args)
}
