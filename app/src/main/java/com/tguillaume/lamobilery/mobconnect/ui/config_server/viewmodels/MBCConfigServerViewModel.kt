package com.tguillaume.lamobilery.mobconnect.ui.config_server.viewmodels

import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import com.tguillaume.lamobilery.mobconnect.utils.errors.MBCErrorKeys

class MBCConfigServerViewModel : MBCBaseViewModel() {

    /**
     * permet de configurer l'ip
     * @param sIP l'ip saisie par l'utilisateur
     */
    fun configureServer(sIP : String){

        // 1. On vérifie que l'ip saisie n'est pas vide
        if(sIP.isBlank()){
            super.mError.onNext(GTAErrorManager.getErrorByCode(MBCErrorKeys.SERVER_IP_EMPTY))
            return
        }


    }
}