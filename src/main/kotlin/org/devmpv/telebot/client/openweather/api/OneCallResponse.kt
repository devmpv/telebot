package org.devmpv.telebot.client.openweather.api

import org.devmpv.telebot.client.openweather.api.data.Current
import org.devmpv.telebot.client.openweather.api.data.Daily
import org.devmpv.telebot.client.openweather.api.data.Hourly
import org.devmpv.telebot.client.openweather.api.data.Minutely

data class OneCallResponse (
	val lat : Double?,
	val lon : Double?,
	val timezone : String?,
	val timezone_offset : Int?,
	val current : Current?,
	val minutely : List<Minutely>?,
	val hourly : List<Hourly>?,
	val daily : List<Daily>?
)
