package com.ziadsyahrul.sub2kade.network

import android.net.Uri
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

//    fun getDetailMatch(idEvent: String?) : String{
//        return BuildConfig.BASE_URL + "lookupevent.php?id=" + idEvent
//    }
//
//    fun getImageTeam(idTeam: String?) : String{
//        return BuildConfig.BASE_URL + "lookupteam.php?id=" + idTeam
//    }

    fun getTeam(idTeam: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
//            .appendPath("api")
//            .appendPath("v1")
//            .appendPath("json")
//            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("lookupteam.php")
            .appendQueryParameter("id", idTeam)
            .build()
            .toString()
    }

    fun getDetailEvent(idEvent: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
//            .appendPath("api")
//            .appendPath("v1")
//            .appendPath("json")
//            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath("lookupevent.php")
            .appendQueryParameter("id", idEvent)
            .build()
            .toString()
    }

}
