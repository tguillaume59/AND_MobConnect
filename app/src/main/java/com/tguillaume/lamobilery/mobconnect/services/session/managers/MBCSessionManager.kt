package com.tguillaume.lamobilery.mobconnect.services.session.managers

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.bird.lib_bird_kotlin.sharedPreferences.GTASharedPrefManagerInterface
import com.tguillaume.lamobilery.mobconnect.BuildConfig
import com.tguillaume.lamobilery.mobconnect.services.home_server.managers.MBCHomeServerManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.session.managers.interfaces.MBCSessionManagerInterface
import com.tguillaume.lamobilery.mobconnect.utils.errors.MBCErrorKeys
import com.tguillaume.lamobilery.mobconnect.utils.network.MBCNetworkResponseKeys.SUCCESS
import com.tguillaume.lamobilery.mobconnect.utils.network.managers.MBCNetworkManagerInterface
import com.tguillaume.lamobilery.mobconnect.utils.shared_prefs.MBCSharedPrefKeys
import org.koin.standalone.inject

class MBCSessionManager : MBCSessionManagerInterface {

    private val TAG : String = MBCSessionManager::class.java.simpleName
    private val mSharedPrefManager : GTASharedPrefManagerInterface by inject()
    private val mHomeServerManager : MBCHomeServerManagerInterface by inject()
    private val mNetworkManager : MBCNetworkManagerInterface by inject()

    override fun homeServerIsConfig(): Boolean {
        return this.getHomeServerIp().isNotBlank()
    }

    override fun getHomeServerIp(): String {
        return mSharedPrefManager.getString(MBCSharedPrefKeys.LOCAL_SERVER_IP)
    }

    override fun saveIPHomeServer(sIp: String, sCallback : GTADefaultCallBack) {
        Log.i(TAG,"saveIPHomeServer")
        // 1. On init le manager réseau avec l'ip saisie
        mNetworkManager.initNetwork(sIp, sWithLog = BuildConfig.DEBUG)

        // 2. On fait un ping au serveur
        mHomeServerManager.pingServer(object : GTADefaultCallBack{
            override fun onCompletion(sObject: Any?, sError: GTAError?) {
                Log.i(TAG,"saveIPHomeServer -> onCompletion")
                if(sError != null){
                    Log.e(TAG,"[ERROR] saveIPHomeServer -> ${sError.mMessage}")
                    sCallback.onCompletion(null, sError)
                }else if(sObject != null && SUCCESS.equals(sObject)){
                    Log.i(TAG,"saveIPHomeServer -> SUCCESS")
                    // on a accès au serveur donc on sauvegarde l'IP
                    mSharedPrefManager.putString(MBCSharedPrefKeys.LOCAL_SERVER_IP, sIp)
                    sCallback.onCompletion(sObject, null)
                }else{
                    Log.e(TAG,"[ERROR] saveIPHomeServer")
                    sCallback.onCompletion(null, GTAErrorManager.getErrorByCode(MBCErrorKeys.DEFAULT))
                }
            }
        })
    }
}