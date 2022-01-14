package org.devmpv.telebot.config

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import org.devmpv.telebot.config.properties.CacheProperties
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CacheConfiguration(
    private val cacheProperties: CacheProperties
) {

    @Bean
    fun cacheManager(): CacheManager {
        val cacheManager = CaffeineCacheManager()
        cacheProperties.cacheList.forEach { entry ->
            cacheManager.registerCustomCache(entry.key, caffeineCacheBuilder(entry.value))
        }
        return cacheManager
    }

    private fun caffeineCacheBuilder(cacheConfig: CacheProperties.CacheConfig): Cache<Any, Any> {
        return Caffeine.newBuilder()
            .initialCapacity(cacheConfig.initialCapacity)
            .maximumSize(cacheConfig.maximumSize)
            .expireAfterWrite(cacheConfig.expireAfterWrite)
            .build()
    }
}
