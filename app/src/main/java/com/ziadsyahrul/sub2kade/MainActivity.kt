package com.ziadsyahrul.sub2kade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.ziadsyahrul.sub2kade.MVP.detail.detailLeague.DetailLeagueActivity
import com.ziadsyahrul.sub2kade.adapter.LeagueAdapter
import com.ziadsyahrul.sub2kade.model.LeagueItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val leagueItemList : MutableList<LeagueItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        rv_league_main.layoutManager = GridLayoutManager(this, 2)
        rv_league_main.adapter = LeagueAdapter(this, leagueItemList){
            Toast.makeText(this, it.idLeague, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailLeagueActivity::class.java)
            startActivity(intent)
        }
    }

    fun initData(){
        val nameLeague = resources.getStringArray(R.array.data_league_name)
        val idLeague = resources.getStringArray(R.array.data_id_league)
        val imageLeague = resources.obtainTypedArray(R.array.data_league_badge)
        leagueItemList.clear()

        for (i in nameLeague.indices){
            leagueItemList.add(LeagueItem(nameLeague[i],
                imageLeague.getResourceId(i, 0),
                idLeague[i]))
        }

        imageLeague.recycle()
    }
}
