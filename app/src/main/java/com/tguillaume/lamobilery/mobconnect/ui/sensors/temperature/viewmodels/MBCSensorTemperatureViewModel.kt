package com.tguillaume.lamobilery.mobconnect.ui.sensors.temperature.viewmodels

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.lamobilery.mobconnect.services.home_server.managers.MBCHomeServerManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCTemperature
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import io.reactivex.subjects.BehaviorSubject
import org.koin.standalone.inject

class MBCSensorTemperatureViewModel : MBCBaseViewModel() {

    private val TAG : String = MBCSensorTemperatureViewModel::class.java.simpleName

    var mTemperatureValue : BehaviorSubject<String> = BehaviorSubject.createDefault("")
    var mHumitityValue : BehaviorSubject<String> = BehaviorSubject.createDefault("")

    private val mHomeServerManager : MBCHomeServerManagerInterface by inject()

    fun loadData(sIdTemperatureSensor: String) {
        super.loadData()
        this.getTemperatureMesure(sIdTemperatureSensor)
    }

    private fun getTemperatureMesure(sIdTemperatureSensor : String){
        Log.i(TAG, "getTemperatureMesure")
        if(sIdTemperatureSensor.isNotBlank()){
            mHomeServerManager.getTemperature(sIdTemperatureSensor, object : GTADefaultCallBack{
                override fun onCompletion(sObject: Any?, sError: GTAError?) {
                    Log.i(TAG, "getTemperatureMesure -> onCompletion")
                    if(sError != null){
                        Log.e(TAG, "[ERROR] getTemperatureMesure -> ${sError.mMessage}")
                        mError.onNext(sError)
                    }else if(sObject != null && sObject is MBCTemperature){
                        mTemperatureValue.onNext("${sObject.mTemperature}")
                        mHumitityValue.onNext("${sObject.mHumidity}")
                    }else{
                        Log.e(TAG, "[ERROR] getTemperatureMesure")
                        onNextDefaultError()
                    }
                }
            })
        }
    }
}