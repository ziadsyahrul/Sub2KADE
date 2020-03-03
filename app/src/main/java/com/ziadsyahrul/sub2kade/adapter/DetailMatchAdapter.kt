package com.ziadsyahrul.sub2kade.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.hawk.Hawk
import com.ziadsyahrul.sub2kade.R
import com.ziadsyahrul.sub2kade.model.EventsItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatchAdapter(
    val context: Context,
    val detail: List<EventsItem>,
    val listener: (EventsItem) -> Unit
) :
    RecyclerView.Adapter<DetailMatchAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(context).inflate(R.layout.activity_detail_match, parent, false)
    )

    override fun getItemCount(): Int = detail.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(detail[position], listener)
    }

    class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItems(items: EventsItem, listener: (EventsItem) -> Unit) {

            tv_date_event_details.text = items.dateEvent
            tv_home_team_details.text = items.strHomeTeam
            tv_home_formation.text = items.strHomeFormation
            tv_away_team_details.text = items.strAwayTeam
            tv_away_formation.text = items.strAwayFormation
            tv_home_goal_details.text = items.strHomeGoalDetails
            tv_away_goal_details.text = items.strAwayGoalDetails
            tv_home_shots.text = items.intHomeShots
            tv_away_shots.text = items.intAwayShots
            tv_home_goalKeeper.text = items.strHomeLineupGoalkeeper
            tv_away_goalKeeper.text = items.strAwayLineupGoalkeeper
            tv_home_defense.text = items.strHomeLineupDefense
            tv_away_defense.text = items.strAwayLineupDefense
            tv_home_midfield.text = items.strHomeLineupMidfield
            tv_away_midfield.text = items.strAwayLineupMidfield
            tv_home_forward.text = items.strHomeLineupForward
            tv_away_forward.text = items.strAwayLineupForward
            tv_home_substitutes.text = items.strHomeLineupSubstitutes
            tv_away_substitutes.text = items.strAwayLineupSubstitutes

            itemView.setOnClickListener {
                listener(items)
            }

        }
    }
}
