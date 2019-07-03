package com.tguillaume.lamobilery.mobconnect.services.sensors.managers

import android.content.Context
import android.graphics.drawable.Drawable

interface MBCUISensorManagerInterface {

    /**
     * Permet de récupérer le nom du capteur depuis la valeur retournée par le Home Server
     * @param sContext le contexte de l'activity
     * @param sValue le type de capteur retourné par le Home Serveur
     */
    fun getSensorName(sContext : Context, sValue : String) : String

    /**
     * Permet de récupérer l'image du capteur depuis la valeur retournée par le Home Server
     * @param sContext le contexte de l'activity
     * @param sValue le type de capteur retourné par le Home Serveur
     */
    fun getSensorPicture(sContext: Context, sValue : String) : Drawable?
}