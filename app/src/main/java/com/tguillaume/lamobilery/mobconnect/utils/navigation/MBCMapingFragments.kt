package com.tguillaume.lamobilery.mobconnect.utils.navigation

import com.tguillaume.bird.lib_bird_kotlin.navigation.GTAFragmentCreator
import com.tguillaume.lamobilery.mobconnect.ui.config_server.MBCConfigServerFragment
import com.tguillaume.lamobilery.mobconnect.ui.home.MBCHomeFragment
import com.tguillaume.lamobilery.mobconnect.ui.sensors.brightness.MBCSensorBrightnessFragment
import com.tguillaume.lamobilery.mobconnect.ui.sensors.temperature.MBCSensorTemperatureFragment

object MBCMapingFragments {

    fun initMapFragment(){
        GTAFragmentCreator.registerNewFragment(MBCFragmentKeys.CONFIG_SERVER, MBCConfigServerFragment::class.java)
        GTAFragmentCreator.registerNewFragment(MBCFragmentKeys.HOME, MBCHomeFragment::class.java)
        GTAFragmentCreator.registerNewFragment(MBCFragmentKeys.SENSOR_TEMPERATURE, MBCSensorTemperatureFragment::class.java)
        GTAFragmentCreator.registerNewFragment(MBCFragmentKeys.SENSOR_BRIGHTNESS, MBCSensorBrightnessFragment::class.java)
    }
}