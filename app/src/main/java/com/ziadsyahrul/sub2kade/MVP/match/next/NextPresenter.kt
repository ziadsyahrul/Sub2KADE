package com.ziadsyahrul.sub2kade.MVP.match.next

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.ziadsyahrul.sub2kade.model.MatchResponse
import com.ziadsyahrul.sub2kade.network.TheSportDBAPI

class NextPresenter(val view: NextView) {
    fun getNextEvent(idLeague: String?){
        AndroidNetworking.get(TheSportDBAPI.getNextMatch(idLeague))
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(MatchResponse::class.java, object : ParsedRequestListener<MatchResponse>{
                override fun onResponse(response: MatchResponse?) {
                    view.getNextEvent(response?.events)
                }

                override fun onError(anError: ANError?) {

                }

            })
    }

}