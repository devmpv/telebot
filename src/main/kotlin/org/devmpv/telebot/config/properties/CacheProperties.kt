package org.devmpv.telebot.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.Duration

@ConstructorBinding
@ConfigurationProperties("cache")
data class CacheProperties(
    val cacheList: Map<String, CacheConfig>
) {

    /**
     * Single class containing cache names to be used in @Cacheable annotation, as an enum and in application properties
     */
    sealed class CacheName {
        object WEATHER_CURRENT: CacheName() {
            const val name = "WEATHER_CURRENT"
        }
    }

    data class CacheConfig(
        val initialCapacity: Int,
        val maximumSize: Long,
        val expireAfterWrite: Duration
    )
}
