package com.tguillaume.lamobilery.mobconnect.ui.sensors.light.viewmodels

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.lamobilery.mobconnect.services.home_server.managers.MBCHomeServerManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCLightStates
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import com.tguillaume.lamobilery.mobconnect.utils.network.MBCNetworkResponseKeys.SUCCESS
import io.reactivex.subjects.BehaviorSubject
import org.koin.standalone.inject

class MBCSensorLightViewmodel : MBCBaseViewModel() {

    private val TAG : String = MBCSensorLightViewmodel::class.java.simpleName

    var mLedRedState : BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)
    var mLedGreenState : BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)

    private val mHomeServerManager : MBCHomeServerManagerInterface by inject()

    fun loadData(sIdTemperatureSensor: String) {
        super.loadData()
        this.getLedState(sIdTemperatureSensor)
    }

    private fun getLedState(sIdLightSensor : String){
        Log.i(TAG, "getLedState")
        if(sIdLightSensor.isNotBlank()){
            mHomeServerManager.getLightStatus(sIdLightSensor, object : GTADefaultCallBack {
                override fun onCompletion(sObject: Any?, sError: GTAError?) {
                    Log.i(TAG, "getLedState -> onCompletion")
                    if(sError != null){
                        Log.e(TAG, "[ERROR] getLedState -> ${sError.mMessage}")
                        mError.onNext(sError)
                    }else if(sObject != null && sObject is MBCLightStates){
                        mLedRedState.onNext(sObject.mRedLED)
                        mLedGreenState.onNext(sObject.mGreenLED)
                    }else{
                        Log.e(TAG, "[ERROR] getLedState")
                        onNextDefaultError()
                    }
                }
            })
        }
    }

    fun changeGreenLed(sIdLightSensor : String){
        val tState : String = if(this.mLedGreenState.value) "ON" else "OFF"
        this.changeLedStatus(sIdLightSensor, "LEDG", tState)
    }

    fun changeRedLed(sIdLightSensor : String){
        val tState : String = if(this.mLedRedState.value) "ON" else "OFF"
        this.changeLedStatus(sIdLightSensor, "LEDR", tState)
    }

    private fun changeLedStatus(sIdLightSensor : String, sColor: String, sState: String){
        Log.i(TAG, "changeLedStatus")
        if(sIdLightSensor.isNotBlank()){
            mHomeServerManager.changeLightState(sIdLightSensor,sColor,sState, object : GTADefaultCallBack {
                override fun onCompletion(sObject: Any?, sError: GTAError?) {
                    Log.i(TAG, "changeLedStatus -> onCompletion")
                    if(sError != null){
                        Log.e(TAG, "[ERROR] changeLedStatus -> ${sError.mMessage}")
                        mError.onNext(sError)
                    }else if(sObject != null && sObject is MBCLightStates){
                        mLedRedState.onNext(sObject.mRedLED)
                        mLedGreenState.onNext(sObject.mGreenLED)
                    }else{
                        Log.e(TAG, "[ERROR] changeLedStatus")
                        onNextDefaultError()
                    }
                }
            })
        }
    }
}