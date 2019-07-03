package com.tguillaume.lamobilery.mobconnect.ui.home.holders

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.view.View
import com.tguillaume.bird.lib_bird_kotlin.adapters.recyclerview.GTADefaultViewHolder
import com.tguillaume.lamobilery.mobconnect.R

class MBCSensorsHolder (sView : View) : GTADefaultViewHolder(sView){

    val mSensorImageView : AppCompatImageView
    val mSensorNameTextView : AppCompatTextView

    init {
        mSensorImageView = sView.findViewById(R.id.holder_home_sensor_logo_imageview)
        mSensorNameTextView = sView.findViewById(R.id.holder_home_sensor_logo_title)
    }
}