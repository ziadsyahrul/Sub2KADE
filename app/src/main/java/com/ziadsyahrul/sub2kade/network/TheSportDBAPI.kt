package com.ziadsyahrul.sub2kade.network

import com.ziadsyahrul.sub2kade.BuildConfig

object TheSportDBAPI {
    fun getDetailLeague(idLeague: String?): String{
        return BuildConfig.BASE_URL + "lookupleague.php?id=" + idLeague
    }

    fun getNextMatch(idLeague: String?) : String{
        return BuildConfig.BASE_URL + "eventsnextleague.php?id=" + idLeague
    }

    fun getPrevMatch(idLeague: String?) : String{
        return BuildConfig.BASE_URL + "eventspastleague.php?id=" + idLeague
    }
}
