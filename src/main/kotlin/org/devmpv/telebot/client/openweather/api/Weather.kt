package org.devmpv.telebot.client.openweather.api

data class Weather (
	val id : Int,
	val main : String,
	val description : String,
	val icon : String
)