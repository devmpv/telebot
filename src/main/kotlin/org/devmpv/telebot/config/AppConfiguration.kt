package org.devmpv.telebot.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableFeignClients(basePackages = ["org.devmpv.telebot.client"])
class AppConfiguration
