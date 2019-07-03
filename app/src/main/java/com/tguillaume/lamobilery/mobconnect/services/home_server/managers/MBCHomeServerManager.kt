package com.tguillaume.lamobilery.mobconnect.services.home_server.managers

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.lamobilery.mobconnect.services.home_server.clients.MBCHomeServerClientIntefaces
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.*
import com.tguillaume.lamobilery.mobconnect.utils.network.MBCNetworkResponseKeys.SUCCESS
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.standalone.inject

class MBCHomeServerManager : MBCHomeServerManagerInterface{

    private val TAG : String = MBCHomeServerManager::class.java.simpleName
    private val mHomeServerClient : MBCHomeServerClientIntefaces by inject()

    /**
     * cf doc dans l'interface
     */
    override fun pingServer(sCallback: GTADefaultCallBack) {
        Log.i(TAG, "pingServer")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            mHomeServerClient.pingServer().await()
            sCallback.onCompletion(SUCCESS, null)
        }
    }

    /**
     * cf doc dans l'interface
     */
    override fun getListLinkedSensors(sCallback: GTADefaultCallBack) {
        Log.i(TAG, "getListLinkedSensors")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            val rList : MutableList<MBCLinkedSensors> = mHomeServerClient.getListLinkedSensors().await()
            sCallback.onCompletion(rList, null)
        }
    }

    /**
     * cf doc dans l'interface
     */
    override fun getTemperature(sIdSensor : String, sCallback: GTADefaultCallBack){
        Log.i(TAG, "getTemperature")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            val tTemperature : MBCTemperature = mHomeServerClient.getTemperature(sIdSensor).await()
            sCallback.onCompletion(tTemperature,null)
        }
    }

    /**
     * cf doc dans l'interface
     */
    override fun getBrightnessState(sIdSensor : String, sCallback: GTADefaultCallBack){
        Log.i(TAG, "getBrightnessState")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            val tBrightnessState : MBCBrightnessState = mHomeServerClient.getBrightnessState(sIdSensor).await()
            sCallback.onCompletion(tBrightnessState,null)
        }
    }

    /**
     * cf doc dans l'interface
     */
    override fun getPressureState(sIdSensor : String, sCallback: GTADefaultCallBack){
        Log.i(TAG, "getPressureState")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            val tPressureState : MBCPressureState = mHomeServerClient.getPressureState(sIdSensor).await()
            sCallback.onCompletion(tPressureState,null)
        }
    }

    /**
     * cf doc dans l'interface
     */
    override fun getMotions(sIdSensor : String, sCallback: GTADefaultCallBack){
        Log.i(TAG, "getMotions")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            val tMotion : MBCMotion = mHomeServerClient.getMotions(sIdSensor).await()
            sCallback.onCompletion(tMotion,null)
        }
    }

    /**
     * cf doc dans l'interface
     */
    override fun getLightStatus(sIdSensor : String, sCallback: GTADefaultCallBack){
        Log.i(TAG, "getLightStatus")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            val tLightState : MBCLightStates = mHomeServerClient.getLightStatus(sIdSensor).await()
            sCallback.onCompletion(tLightState,null)
        }
    }

    /**
     * cf doc dans l'interface
     */
    override fun changeLightState(sId: String, sColor: String, sState: String, sCallback: GTADefaultCallBack){
        Log.i(TAG, "changeLightState")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            val tState : MBCLightStates = mHomeServerClient.changeLightState(sId,sColor,sState).await()
            sCallback.onCompletion(tState,null)
        }
    }

    /**
     * cf doc dans l'interface
     */
    override fun launchSapinOfDevil(sCallback: GTADefaultCallBack){
        Log.i(TAG, "launchSapinOfDevil")
        GlobalScope.launch(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
            val tError: GTAError = GTAErrorManager.getErrorWithThrowable(t)
            sCallback.onCompletion(null, tError)
        }) {
            mHomeServerClient.launchSapinOfDevil("50").await()
            sCallback.onCompletion(SUCCESS,null)
        }
    }
}