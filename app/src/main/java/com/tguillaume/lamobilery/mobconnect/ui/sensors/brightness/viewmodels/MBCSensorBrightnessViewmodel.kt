package com.tguillaume.lamobilery.mobconnect.ui.sensors.brightness.viewmodels

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.lamobilery.mobconnect.services.home_server.managers.MBCHomeServerManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCBrightnessState
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCTemperature
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import com.tguillaume.lamobilery.mobconnect.ui.sensors.temperature.viewmodels.MBCSensorTemperatureViewModel
import io.reactivex.subjects.BehaviorSubject
import org.koin.standalone.inject

class MBCSensorBrightnessViewmodel : MBCBaseViewModel() {

    private val TAG : String = MBCSensorTemperatureViewModel::class.java.simpleName

    var mBrightness : BehaviorSubject<String> = BehaviorSubject.createDefault("")

    private val mHomeServerManager : MBCHomeServerManagerInterface by inject()

    fun loadData(sIdSensorBrightness: String) {
        super.loadData()
        this.getBrightnessState(sIdSensorBrightness)
    }

    private fun getBrightnessState(sIdSensorBrightness : String){
        Log.i(TAG, "getBrightnessState")
        if(sIdSensorBrightness.isNotBlank()){
            mHomeServerManager.getBrightnessState(sIdSensorBrightness, object : GTADefaultCallBack {
                override fun onCompletion(sObject: Any?, sError: GTAError?) {
                    Log.i(TAG, "getBrightnessState -> onCompletion")
                    if(sError != null){
                        Log.e(TAG, "[ERROR] getBrightnessState -> ${sError.mMessage}")
                        mError.onNext(sError)
                    }else if(sObject != null && sObject is MBCBrightnessState){
                        mBrightness.onNext("${sObject.mStateStr}")
                    }else{
                        Log.e(TAG, "[ERROR] getBrightnessState")
                        onNextDefaultError()
                    }
                }
            })
        }
    }
}