package org.devmpv.telebot.config

import org.devmpv.telebot.client.ClientPackageMarker
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableCaching
@EnableScheduling
@EnableFeignClients(basePackageClasses = [ClientPackageMarker::class])
class AppConfiguration
