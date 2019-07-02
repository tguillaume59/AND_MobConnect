package com.tguillaume.lamobilery.mobconnect.services.session.managers

import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.bird.lib_bird_kotlin.sharedPreferences.GTASharedPrefManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.home_server.managers.MBCHomeServerManagerInterface
import com.tguillaume.lamobilery.mobconnect.services.session.managers.interfaces.MBCSessionManagerInterface
import com.tguillaume.lamobilery.mobconnect.utils.errors.MBCErrorKeys
import com.tguillaume.lamobilery.mobconnect.utils.shared_prefs.MBCSharedPrefKeys
import org.koin.standalone.inject

class MBCSessionManager : MBCSessionManagerInterface {

    private val mSharedPrefManager : GTASharedPrefManagerInterface by inject()
    private val mHomeServerManager : MBCHomeServerManagerInterface by inject()

    override fun homeServerIsConfig(): Boolean {
        return this.getHomeServerIp().isNotBlank()
    }

    override fun getHomeServerIp(): String {
        return mSharedPrefManager.getString(MBCSharedPrefKeys.LOCAL_SERVER_IP)
    }

    override fun saveIPHomeServer(sIp: String, sCallback : GTADefaultCallBack) {
        mHomeServerManager.pingServer(object : GTADefaultCallBack{
            override fun onCompletion(sObject: Any?, sError: GTAError?) {
                if(sError != null){
                    sCallback.onCompletion(null, sError)
                }else if(sObject != null){
                    // on a accès au serveur donc on sauvegarde l'IP
                    mSharedPrefManager.putString(MBCSharedPrefKeys.LOCAL_SERVER_IP, sIp)
                    sCallback.onCompletion(sObject, null)
                }else{
                    sCallback.onCompletion(null, GTAErrorManager.getErrorByCode(MBCErrorKeys.DEFAULT))
                }
            }
        })
    }
}