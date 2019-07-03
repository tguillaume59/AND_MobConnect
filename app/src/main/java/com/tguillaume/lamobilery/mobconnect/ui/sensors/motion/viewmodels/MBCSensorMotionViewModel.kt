package com.tguillaume.lamobilery.mobconnect.ui.sensors.motion.viewmodels

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.lamobilery.mobconnect.services.home_server.managers.MBCHomeServerManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCMotion
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import io.reactivex.subjects.BehaviorSubject
import org.koin.standalone.inject

class MBCSensorMotionViewModel : MBCBaseViewModel() {

    private val TAG : String = MBCSensorMotionViewModel::class.java.simpleName

    var mMotionState : BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)
    var mLastDetectionDate : BehaviorSubject<String> = BehaviorSubject.createDefault("")

    private val mHomeServerManager : MBCHomeServerManagerInterface by inject()

    fun loadData(sIdTemperatureSensor: String) {
        super.loadData()
        this.getMotion(sIdTemperatureSensor)
    }

    private fun getMotion(sIdTemperatureSensor : String){
        Log.i(TAG, "getMotion")
        if(sIdTemperatureSensor.isNotBlank()){
            mHomeServerManager.getMotions(sIdTemperatureSensor, object : GTADefaultCallBack {
                override fun onCompletion(sObject: Any?, sError: GTAError?) {
                    Log.i(TAG, "getMotion -> onCompletion")
                    if(sError != null){
                        Log.e(TAG, "[ERROR] getMotion -> ${sError.mMessage}")
                        mError.onNext(sError)
                    }else if(sObject != null && sObject is MBCMotion){
                        mMotionState.onNext(sObject.mStatus)
                        mLastDetectionDate.onNext(sObject.mLastDetection)
                    }else{
                        Log.e(TAG, "[ERROR] getPressureState")
                        onNextDefaultError()
                    }
                }
            })
        }
    }
}