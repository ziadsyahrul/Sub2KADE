package com.ziadsyahrul.sub2kade.MVP.detail.detailMatch

import com.ziadsyahrul.sub2kade.model.EventsItem
import com.ziadsyahrul.sub2kade.model.Team

interface DetailMatchView {
    fun showDetailMatch(data: EventsItem)
    fun showTeam(data: Team)
}