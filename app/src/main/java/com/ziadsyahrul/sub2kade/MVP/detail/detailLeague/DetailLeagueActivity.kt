package com.ziadsyahrul.sub2kade.MVP.detail.detailLeague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orhanobut.hawk.Hawk
import com.squareup.picasso.Picasso
import com.ziadsyahrul.sub2kade.R
import com.ziadsyahrul.sub2kade.adapter.SectionPagerAdapter
import com.ziadsyahrul.sub2kade.model.LeaguesItem
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeagueActivity : AppCompatActivity(),
    DetailLeagueView {


    companion object {
        const val ID_LEAGUE = "id_league"
    }

    private var presenter: DetailLeaguePresenter =
        DetailLeaguePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

        val id_league = Hawk.get(ID_LEAGUE, "")
        presenter.getDetailLeague(id_league)


        val pagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        vp_match.adapter = pagerAdapter
        tab_detail.setupWithViewPager(vp_match)


    }

    override fun showDetailLeague(data: List<LeaguesItem>) {
        Picasso.get().load(data[0].strBadge).fit().into(img_detail_league_badge)
        tv_str_detail_league_name.text = data[0].strLeague
        tv_detail_descriptions.text = data[0].strDescriptionEN
        tv_str_sport.text = data[0].strSport
        tv_str_country.text = data[0].strCountry
        tv_str_web.text = data[0].strWebsite
    }

}
