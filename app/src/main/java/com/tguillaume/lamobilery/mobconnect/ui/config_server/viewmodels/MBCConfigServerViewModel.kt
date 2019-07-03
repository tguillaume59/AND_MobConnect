package com.tguillaume.lamobilery.mobconnect.ui.config_server.viewmodels

import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.lamobilery.mobconnect.services.session.managers.interfaces.MBCSessionManagerInterface
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import com.tguillaume.lamobilery.mobconnect.utils.errors.MBCErrorKeys
import com.tguillaume.lamobilery.mobconnect.utils.network.MBCNetworkResponseKeys.SUCCESS
import io.reactivex.subjects.BehaviorSubject
import org.koin.standalone.inject

class MBCConfigServerViewModel : MBCBaseViewModel() {

    private val TAG : String = MBCConfigServerViewModel::class.java.simpleName

    var mConfigServerSuccess : BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)

    private val mSessionManager : MBCSessionManagerInterface by inject()

    /**
     * permet de configurer l'ip
     * @param sIP l'ip saisie par l'utilisateur
     */
    fun configureServer(sIP : String){
        Log.i(TAG, "saveIPHomeServer")

        // 1. On vérifie que l'ip saisie n'est pas vide
        if(sIP.isBlank()){
            super.mError.onNext(GTAErrorManager.getErrorByCode(MBCErrorKeys.SERVER_IP_EMPTY))
            return
        }

        // 2. On demande au manager de configurer l'app en la liant au serveur
        mSessionManager.saveIPHomeServer(sIP, object : GTADefaultCallBack{
            override fun onCompletion(sObject: Any?, sError: GTAError?) {
                // 3. On a un résultat à notre configuration
                Log.i(TAG, "saveIPHomeServer -> onCompletion")
                if(sError != null){
                    // 3.1 Une erreur est arrivée
                    Log.e(TAG, "[ERROR] saveIPHomeServer -> ${sError.mMessage}")
                    mError.onNext(sError)
                }else if( sObject != null && SUCCESS.equals(sObject)){
                    // 3.2 la configuration a réussi, nous avons une réponse du Home server
                    Log.i(TAG, "saveIPHomeServer -> SUCCESS")
                    mConfigServerSuccess.onNext(true)
                }else{
                    // 3.3 Erreur inconnue
                    mError.onNext(GTAErrorManager.getErrorByCode(MBCErrorKeys.DEFAULT))
                }
            }
        })
    }
}