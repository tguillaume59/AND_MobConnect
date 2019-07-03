package com.tguillaume.lamobilery.mobconnect.services.sensors.managers

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.services.sensors.models.MBCEnumSensorsAvailable

class MBCUISensorManager : MBCUISensorManagerInterface {

    override fun getSensorName(sContext : Context, sValue : String) : String{
        return when (sValue){
            MBCEnumSensorsAvailable.TEMPERATURE -> sContext.getString(R.string.sensor_temperature)
            MBCEnumSensorsAvailable.BRIGHTNESS -> sContext.getString(R.string.sensor_brightness)
            MBCEnumSensorsAvailable.LIGHT -> sContext.getString(R.string.sensor_light)
            MBCEnumSensorsAvailable.PRESSURE -> sContext.getString(R.string.sensor_pressure)
            MBCEnumSensorsAvailable.MOTION -> sContext.getString(R.string.sensor_motion)
            else -> sContext.getString(R.string.sensor_default)
        }
    }

    override fun getSensorPicture(sContext: Context, sValue : String) : Drawable?{
        return when (sValue){
            MBCEnumSensorsAvailable.TEMPERATURE -> ContextCompat.getDrawable(sContext, R.drawable.ic_sensor_temperature)
            MBCEnumSensorsAvailable.BRIGHTNESS -> ContextCompat.getDrawable(sContext, R.drawable.ic_sensor_brightness)
            MBCEnumSensorsAvailable.LIGHT -> ContextCompat.getDrawable(sContext, R.drawable.ic_sensor_light)
            MBCEnumSensorsAvailable.PRESSURE -> ContextCompat.getDrawable(sContext, R.drawable.ic_sensor_pressure)
            MBCEnumSensorsAvailable.MOTION -> ContextCompat.getDrawable(sContext, R.drawable.ic_sensor_motion)
            else -> ContextCompat.getDrawable(sContext, R.drawable.ic_default_sensor)
        }
    }
}