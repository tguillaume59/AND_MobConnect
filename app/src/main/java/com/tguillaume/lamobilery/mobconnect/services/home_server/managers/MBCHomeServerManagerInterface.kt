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

    /**
     * Permet de récupérer la température de la piece
     * @param sIdSensor l'id du capteur que l'on veut interroger
     * @param sCallback le callback
     */
    fun getTemperature(sIdSensor : String, sCallback: GTADefaultCallBack)


    /**
     * Permet de récupérer l'état de luminosité de la pièce
     * @param sIdSensor l'id du capteur que l'on veut interroger
     * @param sCallback le callback
     */
    fun getBrightnessState(sIdSensor : String, sCallback: GTADefaultCallBack)

    /**
     * Permet de récupérer l'état du capteur de pression
     * @param sIdSensor l'id du capteur que l'on veut interroger
     * @param sCallback le callback
     */
    fun getPressureState(sIdSensor : String, sCallback: GTADefaultCallBack)

    /**
     * Permet de récupérer les informations du capteur de présence
     * @param sIdSensor l'id du capteur que l'on veut interroger
     * @param sCallback le callback
     */
    fun getMotions(sIdSensor : String, sCallback: GTADefaultCallBack)

    /**
     * Permet de récupérer l'état des leds
     * @param sIdSensor l'id du capteur que l'on veut interroger
     * @param sCallback le callback
     */
    fun getLightStatus(sIdSensor : String, sCallback: GTADefaultCallBack)

    /**
     * Permet de changer l'état d'une led
     * @param sId l'id du capteur
     * @param sColor la led a modifier (color (enum) : LEDG ou LEDR)
     * @param sState le state (tatus (enum) : ON ou OFF)
     * @param sCallback le callback
     */
    fun changeLightState(sId: String, sColor: String, sState: String, sCallback: GTADefaultCallBack)

    /**
     * @EasterEggs
     * Permet de transformer le capteur en un sapin de noel
     * @param sCallback le callback
     */
    fun launchSapinOfDevil(sCallback: GTADefaultCallBack)
}