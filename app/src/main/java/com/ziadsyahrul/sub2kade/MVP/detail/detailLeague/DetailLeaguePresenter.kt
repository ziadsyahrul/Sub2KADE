package com.ziadsyahrul.sub2kade.MVP.detail.detailLeague

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.ziadsyahrul.sub2kade.model.LeaguesResponse
import com.ziadsyahrul.sub2kade.network.TheSportDBAPI

class DetailLeaguePresenter(val view: DetailLeagueView) {
    fun getDetailLeague(idLeague: String?){
        AndroidNetworking.get(TheSportDBAPI.getDetailLeague(idLeague))
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(LeaguesResponse::class.java, object : ParsedRequestListener<LeaguesResponse>{

                override fun onResponse(response: LeaguesResponse?) {
                    response?.leagues?.let { view.showDetailLeague(it) }
                }

                override fun onError(anError: ANError?) {

                }

            })
    }
}

