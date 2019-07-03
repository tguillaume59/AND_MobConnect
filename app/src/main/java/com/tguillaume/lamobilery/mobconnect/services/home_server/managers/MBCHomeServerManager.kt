package com.tguillaume.lamobilery.mobconnect.services.home_server.managers

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.lamobilery.mobconnect.services.home_server.clients.MBCHomeServerClientIntefaces
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCLinkedSensors
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
}