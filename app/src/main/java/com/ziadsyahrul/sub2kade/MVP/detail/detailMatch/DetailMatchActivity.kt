package com.ziadsyahrul.sub2kade.MVP.detail.detailMatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.ziadsyahrul.sub2kade.R
import com.ziadsyahrul.sub2kade.model.EventsItem
import com.ziadsyahrul.sub2kade.model.Team
import com.ziadsyahrul.sub2kade.network.ApiRepository
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatchActivity : AppCompatActivity(), DetailMatchView {


    private var idEvent: String = ""
    private var idHomeTeam: String = ""
    private var idAwayTeam: String = ""
    private lateinit var presenter: DetailMatchPresenter



    override fun showDetailMatch(data: EventsItem) {
        idHomeTeam = data.homeTeamId.toString()
        idAwayTeam = data.idAwayTeam.toString()
        when (data.idEvent) {
            idEvent -> {

                tv_date_event_details.text = data.dateEvent
                tv_home_team_details.text = data.strHomeTeam
                tv_away_team_details.text = data.strAwayTeam
                tv_home_score_details.text = data.intHomeScore
                tv_away_score_details.text = data.intAwayScore
                tv_home_formation.text = data.strHomeFormation
                tv_away_formation.text = data.strAwayFormation
                tv_home_goal_details.text = data.strHomeGoalDetails
                tv_away_goal_details.text = data.strAwayGoalDetails
                tv_home_shots.text = data.intHomeShots
                tv_away_shots.text = data.intAwayShots
                tv_home_goalKeeper.text = data.strHomeLineupGoalkeeper
                tv_away_goalKeeper.text = data.strAwayLineupGoalkeeper
                tv_home_defense.text = data.strHomeLineupDefense
                tv_away_defense.text = data.strAwayLineupDefense
                tv_home_midfield.text = data.strHomeLineupMidfield
                tv_away_midfield.text = data.strAwayLineupMidfield
                tv_home_forward.text = data.strHomeLineupForward
                tv_away_forward.text = data.strAwayLineupForward
                tv_home_substitutes.text = data.strHomeLineupSubstitutes
                tv_away_substitutes.text = data.strAwayLineupSubstitutes
            }
        }

        presenter.getImageTeam(idHomeTeam)
        presenter.getImageTeam(idAwayTeam)
    }

    override fun showTeam(data: Team) {
        when(data.teamId){
            idHomeTeam -> {
                Picasso.get().load(data.teamBadge).into(img_home_badge)
            }

            idAwayTeam -> {
                Picasso.get().load(data.teamBadge).into(img_away_badge)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        val request = ApiRepository()
        val gson = Gson()
        idEvent = intent.getStringExtra("id")
        idHomeTeam = intent.getStringExtra("idHome")
        presenter = DetailMatchPresenter(this, request, gson)

        presenter.getDetailMatch(idEvent)

    }
}
