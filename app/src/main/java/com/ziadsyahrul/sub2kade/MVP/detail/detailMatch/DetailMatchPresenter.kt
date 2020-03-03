package com.ziadsyahrul.sub2kade.MVP.detail.detailMatch

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.google.gson.Gson
import com.ziadsyahrul.sub2kade.model.DetailMatchResponse
import com.ziadsyahrul.sub2kade.model.TeamResponse
import com.ziadsyahrul.sub2kade.network.ApiRepository
import com.ziadsyahrul.sub2kade.network.TheSportDBAPI
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailMatchPresenter(val view: DetailMatchView, private val apiRepository: ApiRepository, private val gson: Gson) {
//    fun getDetailMatch(idEvent: String?){
//        AndroidNetworking.get(TheSportDBAPI.getDetailMatch(idEvent))
//            .setPriority(Priority.HIGH)
//            .build()
//            .getAsObject(DetailMatchResponse::class.java, object : ParsedRequestListener<DetailMatchResponse>{
//                override fun onResponse(response: DetailMatchResponse?) {
//                    response?.events?.let { view.showDetailMatch(it) }
//                }
//
//                override fun onError(anError: ANError?) {
//
//                }
//
//            })
//    }

    fun getImageTeam(idTeam: String?){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBAPI.getTeam(idTeam)), TeamResponse::class.java)

            uiThread {
                view.showTeam(data.teams.first())
            }
        }
    }

    fun getDetailMatch(idEvent: String?){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDBAPI.getDetailEvent(idEvent)), DetailMatchResponse::class.java)

            uiThread {
                view.showDetailMatch(data.events!!.first())
            }
        }
    }
}