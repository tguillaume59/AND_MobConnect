package com.tguillaume.lamobilery.mobconnect.utils.navigation.managers

interface MBCSensorFragmentManagerInterface {

    /**
     * Permet de récupérer la clé du fragment à afficher grâce à l'énum du capteur reçue depuis
     * le Home Server
     * @param sSensorType le type de capteur
     * @return la clé du fragment
     */
    fun getFragmentKeyWithSensorType(sSensorType : String) : String
}