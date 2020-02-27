package com.ziadsyahrul.sub2kade.MVP.match.prev


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.orhanobut.hawk.Hawk
import com.ziadsyahrul.sub2kade.MVP.detail.DetailLeagueActivity

import com.ziadsyahrul.sub2kade.R
import com.ziadsyahrul.sub2kade.adapter.PreviousAdapter
import com.ziadsyahrul.sub2kade.model.EventsItem
import kotlinx.android.synthetic.main.fragment_previous_match.*

/**
 * A simple [Fragment] subclass.
 */
class PreviousMatchFragment : Fragment(), PreviousView {

    private val presenter: PreviousPresenter = PreviousPresenter(this)
    private var previousAdapter: PreviousAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idLeague = Hawk.get(DetailLeagueActivity.ID_LEAGUE, "")
        presenter.getPreviousEvent(idLeague)
        rv_prev_match.layoutManager = LinearLayoutManager(context)
    }


    override fun getPreviousEvent(data: List<EventsItem?>?) {
        previousAdapter = PreviousAdapter(data)
        rv_prev_match.adapter = previousAdapter
    }

}
