package org.devmpv.telebot.client.openweather.api.data

data class Current (
	val dt : Long,
	val sunrise : Long,
	val sunset : Long,
	val temp : Double,
	val feels_like : Double,
	val pressure : Double,
	val humidity : Int,
	val dew_point : Double,
	val uvi : Double,
	val clouds : Int,
	val visibility : Int,
	val wind_speed : Double,
	val wind_deg : Int,
	val wind_gust : Double,
	val weather : List<Weather>
)