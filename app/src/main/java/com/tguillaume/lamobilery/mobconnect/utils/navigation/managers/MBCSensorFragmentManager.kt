package com.tguillaume.lamobilery.mobconnect.utils.navigation.managers

import com.tguillaume.bird.lib_bird_kotlin.navigation.enums.GTADefaultEnumFragment
import com.tguillaume.lamobilery.mobconnect.services.sensors.models.MBCEnumSensorsAvailable
import com.tguillaume.lamobilery.mobconnect.utils.navigation.MBCFragmentKeys

class MBCSensorFragmentManager : MBCSensorFragmentManagerInterface {

    override fun getFragmentKeyWithSensorType(sSensorType : String) : String{
        return when (sSensorType){
            MBCEnumSensorsAvailable.TEMPERATURE -> MBCFragmentKeys.SENSOR_TEMPERATURE
            MBCEnumSensorsAvailable.BRIGHTNESS -> MBCFragmentKeys.SENSOR_BRIGHTNESS
            else -> GTADefaultEnumFragment.DEFAULT_ERROR_FRAGMENT
        }

    }
}