package com.ziadsyahrul.sub2kade.MVP.match.prev


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ziadsyahrul.sub2kade.R
import com.ziadsyahrul.sub2kade.model.EventsItem

/**
 * A simple [Fragment] subclass.
 */
class PreviousMatchFragment : Fragment(), PreviousView {

//    private val presenter: PreviousPresenter = PreviousPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun getPreviousEvent(data: List<EventsItem?>?) {

    }

}
