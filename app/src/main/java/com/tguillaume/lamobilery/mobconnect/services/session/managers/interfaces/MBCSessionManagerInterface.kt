package com.tguillaume.lamobilery.mobconnect.services.session.managers.interfaces

import com.tguillaume.bird.lib_bird_kotlin.callbacks.GTADefaultCallBack
import org.koin.standalone.KoinComponent

interface MBCSessionManagerInterface : KoinComponent {

    /**
     * Permet de savoir si le serveur domotique à déjà été configuré
     * @return true il a déjà été configuré sinon faux
     */
    fun homeServerIsConfig() : Boolean

    /**
     * Permet de récupérer l'adresse IP du serveur
     * @return l'adresse IP
     */
    fun getHomeServerIp() : String

    /***
     * Permet de sauvegarder l'ip du serveur
     * @param sIp l'ip du serveur à sauvegarder
     * @param sCallback le callback
     */
    fun saveIPHomeServer(sIp : String, sCallback : GTADefaultCallBack)
}