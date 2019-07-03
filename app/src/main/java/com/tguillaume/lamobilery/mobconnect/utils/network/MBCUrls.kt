package com.tguillaume.lamobilery.mobconnect.utils.network

object MBCUrls {

    const val URL_PRM_ID : String = "prm_id"
    const val URL_PRM_COLOR : String = "prm_color"
    const val URL_PRM_STATUS : String = "prm_status"
    const val URL_PRM_NUMBER : String = "prm_number"

    const val PING_SERVER : String = "ping/"

    const val SENSOR_AVAILABLE : String = "home/"

    const val SENSOR_TEMPERATURE : String = "temperature/{$URL_PRM_ID}/"
    const val SENSOR_BRIGHTNESS : String = "daynight/{$URL_PRM_ID}/"
    const val SENSOR_PRESSURE : String = "pressure/{$URL_PRM_ID}/"
    const val SENSOR_MOTION : String = "detect/{$URL_PRM_ID}/"
    const val SENSOR_LIGHT : String = "led/{$URL_PRM_ID}/status"
    const val SENSOR_LIGHT_CHANGE_STATE : String = "led/{$URL_PRM_ID}/{$URL_PRM_COLOR}/{$URL_PRM_STATUS}"
    const val SENSOR_LIGHT_SAPIN_OF_DEVIL : String = "led/sapinOfDevil/{$URL_PRM_NUMBER}"
}