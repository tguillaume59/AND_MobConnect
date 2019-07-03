package com.tguillaume.lamobilery.mobconnect.services.home_server.managers

import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import org.koin.standalone.KoinComponent

interface MBCHomeServerManagerInterface : KoinComponent {

    /**
     * Permet de vérifier si le serveur est fonctionnel
     * @param sCallback le callback
     */
    fun pingServer( sCallback : GTADefaultCallBack)

    /**
     * Permet de récupérer la liste des capteurs disponibles
     * @param sCallback le callback
     */
    fun getListLinkedSensors(sCallback: GTADefaultCallBack)
}