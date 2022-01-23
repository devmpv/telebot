package org.devmpv.telebot.client.openweather.api.data

data class Daily (
	val dt : Long,
	val sunrise : Int,
	val sunset : Int,
	val moonrise : Int,
	val moonset : Int,
	val moon_phase : Double,
	val temp : Temp,
	val feels_like : FeelsLike,
	val pressure : Double,
	val humidity : Int,
	val dew_point : Double,
	val wind_speed : Double,
	val wind_deg : Int,
	val wind_gust : Double,
	val weather : List<Weather>,
	val clouds : Int,
	val pop : Int,
	val rain : Double,
	val uvi : Double
)
