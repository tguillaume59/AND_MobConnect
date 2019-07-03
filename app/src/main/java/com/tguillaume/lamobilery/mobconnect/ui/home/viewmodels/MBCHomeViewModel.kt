package com.tguillaume.lamobilery.mobconnect.ui.home.viewmodels

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.lamobilery.mobconnect.services.home_server.managers.MBCHomeServerManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCLinkedSensors
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import io.reactivex.subjects.BehaviorSubject
import org.koin.standalone.inject

class MBCHomeViewModel : MBCBaseViewModel() {

    private val TAG : String = MBCHomeViewModel::class.java.simpleName

    var mListLinkedSensors : BehaviorSubject<MutableList<MBCLinkedSensors>> = BehaviorSubject.createDefault(ArrayList())

    private val mHomeServerManager : MBCHomeServerManagerInterface by inject()

    override fun loadData() {
        super.loadData()
        this.loadListLinkedSensors()
    }

    /**
     * Permet de récupérer la liste des capteurs disponibles
     */
    private fun loadListLinkedSensors(){
        Log.i(TAG, "loadListLinkedSensors")
        mHomeServerManager.getListLinkedSensors(object : GTADefaultCallBack{
            override fun onCompletion(sObject: Any?, sError: GTAError?) {
                Log.i(TAG, "loadListLinkedSensors -> onCompletion")
                if(sError != null){
                    Log.e(TAG, "[ERROR] loadListLinkedSensors -> ${sError.mMessage}")
                    mError.onNext(sError)
                }else if(sObject != null && sObject is MutableList<*>){
                    mListLinkedSensors.onNext(sObject as MutableList<MBCLinkedSensors>)
                }else {
                    Log.e(TAG, "[ERROR] loadListLinkedSensors")
                    onNextDefaultError()
                }
            }
        })
    }

}