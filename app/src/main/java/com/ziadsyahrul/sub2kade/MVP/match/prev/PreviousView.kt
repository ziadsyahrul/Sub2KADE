package com.ziadsyahrul.sub2kade.MVP.match.prev

import com.ziadsyahrul.sub2kade.model.EventsItem

interface PreviousView {
    fun getPreviousEvent(data: List<EventsItem?>?)
}