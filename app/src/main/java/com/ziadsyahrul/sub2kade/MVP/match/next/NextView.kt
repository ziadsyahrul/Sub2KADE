package com.ziadsyahrul.sub2kade.MVP.match.next

import com.ziadsyahrul.sub2kade.model.EventsItem

interface NextView {
    fun getNextEvent(data: List<EventsItem?>?)

}