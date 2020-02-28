package com.ziadsyahrul.sub2kade.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orhanobut.hawk.Hawk
import com.ziadsyahrul.sub2kade.MVP.detail.DetailLeagueActivity
import com.ziadsyahrul.sub2kade.R
import com.ziadsyahrul.sub2kade.model.LeagueItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.league_item.*
import kotlinx.android.synthetic.main.league_item.view.*

class LeagueAdapter(val context: Context, val league: List<LeagueItem>, val listener : (LeagueItem) -> Unit) :
    RecyclerView.Adapter<LeagueAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(LayoutInflater.from(context).inflate(
        R.layout.league_item,parent, false))

    override fun getItemCount(): Int = league.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(league[position], listener)
    }

    class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{

        fun bindItem(items: LeagueItem, listener: (LeagueItem) -> Unit){
            tv_league_name.text = items.nama
            Glide.with(itemView.context).load(items.image).into(itemView.img_league_badge)

            itemView.setOnClickListener {
                listener(items)
                // mengirimkan data idLeague ke Detail activity
                Hawk.put(DetailLeagueActivity.ID_LEAGUE, items.idLeague)
            }

        }

    }
}