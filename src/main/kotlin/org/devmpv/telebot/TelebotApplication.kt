package org.devmpv.telebot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TelebotApplication

fun main(args: Array<String>) {
    runApplication<TelebotApplication>(*args)
}
