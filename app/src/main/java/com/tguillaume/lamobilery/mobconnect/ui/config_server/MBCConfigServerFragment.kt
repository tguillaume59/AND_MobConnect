package com.tguillaume.lamobilery.mobconnect.ui.config_server

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments.MBCBaseFragment

class MBCConfigServerFragment : MBCBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_config_server, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initOnClick(){

    }
}