package com.ziadsyahrul.sub2kade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ziadsyahrul.sub2kade.R
import com.ziadsyahrul.sub2kade.model.EventsItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.detail_item.*

class PreviousAdapter(val items: List<EventsItem?>?) :
    RecyclerView.Adapter<PreviousAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.detail_item,
                parent,
                false
            )
        )


    override fun getItemCount(): Int {
        return items!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(items?.get(position))
    }

    class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItems(items: EventsItem?){
            tv_str_event.text = items?.strEvent
            tv_str_league.text = items?.strLeague
            tv_str_home_score.text = items?.intHomeScore
            tv_str_away_score.text = items?.intAwayScore
            tv_date.text = items?.dateEvent
        }
    }
}
