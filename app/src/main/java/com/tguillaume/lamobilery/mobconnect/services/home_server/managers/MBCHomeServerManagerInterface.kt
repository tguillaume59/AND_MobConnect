package com.tguillaume.lamobilery.mobconnect.services.home_server.managers

import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack

interface MBCHomeServerManagerInterface {

    /**
     * Permet de vérifier si le serveur est fonctionnel
     * @param sCallback le callback
     */
    fun pingServer( sCallback : GTADefaultCallBack)
}