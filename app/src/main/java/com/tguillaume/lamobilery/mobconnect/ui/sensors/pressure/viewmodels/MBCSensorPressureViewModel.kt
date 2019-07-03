package com.tguillaume.lamobilery.mobconnect.ui.sensors.pressure.viewmodels

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.lamobilery.mobconnect.services.home_server.managers.MBCHomeServerManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCPressureState
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import io.reactivex.subjects.BehaviorSubject
import org.koin.standalone.inject

class MBCSensorPressureViewModel : MBCBaseViewModel() {

    private val TAG : String = MBCSensorPressureViewModel::class.java.simpleName

    var mPressureState : BehaviorSubject<String> = BehaviorSubject.createDefault("")

    private val mHomeServerManager : MBCHomeServerManagerInterface by inject()

    fun loadData(sIdTemperatureSensor: String) {
        super.loadData()
        this.getPressureState(sIdTemperatureSensor)
    }

    private fun getPressureState(sIdTemperatureSensor : String){
        Log.i(TAG, "getPressureState")
        if(sIdTemperatureSensor.isNotBlank()){
            mHomeServerManager.getPressureState(sIdTemperatureSensor, object : GTADefaultCallBack {
                override fun onCompletion(sObject: Any?, sError: GTAError?) {
                    Log.i(TAG, "getPressureState -> onCompletion")
                    if(sError != null){
                        Log.e(TAG, "[ERROR] getPressureState -> ${sError.mMessage}")
                        mError.onNext(sError)
                    }else if(sObject != null && sObject is MBCPressureState){
                        mPressureState.onNext(sObject.mStateStr)
                    }else{
                        Log.e(TAG, "[ERROR] getPressureState")
                        onNextDefaultError()
                    }
                }
            })
        }
    }
}