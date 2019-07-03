package com.tguillaume.lamobilery.mobconnect.utils.network.managers

import android.content.Context

interface MBCNetworkManagerInterface {

    /**
     * Permet d'initialiser le manager
     * @param sContext le context de l'application
     */
    fun initManager(sContext : Context)

    /**
     * Permet d'initialiser les accès au réseau via l'ip du home serveur
     * saisi pendant la configuration
     * @param sIp l'ip du home serveur
     * @param sWithLog true pour afficher les log http (doivent être masqué en release)
     */
    fun initNetwork(sIp : String , sWithLog : Boolean)
}