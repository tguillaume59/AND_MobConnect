package com.tguillaume.lamobilery.mobconnect.utils.navigation

import com.tguillaume.bird.lib_bird_kotlin.navigation.GTAFragmentCreator
import com.tguillaume.lamobilery.mobconnect.ui.config_server.MBCConfigServerFragment

object MBCMapingFragments {

    fun initMapFragment(){
        GTAFragmentCreator.registerNewFragment(MBCFragmentKeys.CONFIG_SERVER, MBCConfigServerFragment::class.java)
    }
}