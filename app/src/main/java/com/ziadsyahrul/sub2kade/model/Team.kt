package com.ziadsyahrul.sub2kade.model

import com.google.gson.annotations.SerializedName

class Team(
    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge: String? = null
)
