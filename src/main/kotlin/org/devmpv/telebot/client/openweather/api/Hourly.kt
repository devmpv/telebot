package org.devmpv.telebot.client.openweather.api

data class Hourly (
	val dt : Long,
	val temp : Double,
	val feels_like : Double,
	val pressure : Double,
	val humidity : Int,
	val dew_point : Double,
	val uvi : Int,
	val clouds : Int,
	val visibility : Int,
	val wind_speed : Double,
	val wind_deg : Int,
	val wind_gust : Double,
	val weather : List<Weather>,
	val pop : Double
)