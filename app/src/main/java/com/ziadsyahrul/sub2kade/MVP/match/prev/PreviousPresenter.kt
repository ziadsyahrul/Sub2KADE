package com.ziadsyahrul.sub2kade.MVP.match.prev

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.ziadsyahrul.sub2kade.model.MatchResponse
import com.ziadsyahrul.sub2kade.network.TheSportDBAPI

class PreviousPresenter(val view: PreviousView) {
    fun getPreviousEvent(idLeague: String?){
        AndroidNetworking.get(TheSportDBAPI.getPrevMatch(idLeague))
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(MatchResponse::class.java, object : ParsedRequestListener<MatchResponse>{
                override fun onResponse(response: MatchResponse?) {
                    view.getPreviousEvent(response?.events)
                }

                override fun onError(anError: ANError?) {

                }

            })
    }
}