package com.ziadsyahrul.sub2kade.model

import com.google.gson.annotations.SerializedName

data class MatchResponse(

	@field:SerializedName("events")
	val events: List<EventsItem>? = null
)