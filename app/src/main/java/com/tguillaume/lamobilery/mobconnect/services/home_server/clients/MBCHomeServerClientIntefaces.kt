package com.tguillaume.lamobilery.mobconnect.services.home_server.clients

import com.tguillaume.lamobilery.mobconnect.services.home_server.models.*
import com.tguillaume.lamobilery.mobconnect.utils.network.MBCUrls
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface MBCHomeServerClientIntefaces {

    @GET(MBCUrls.PING_SERVER)
    fun pingServer() : Deferred<Unit>

    @GET(MBCUrls.SENSOR_AVAILABLE)
    fun getListLinkedSensors() : Deferred<MutableList<MBCLinkedSensors>>

    @GET(MBCUrls.SENSOR_TEMPERATURE)
    fun getTemperature(@Path(MBCUrls.URL_PRM_ID) sId : String ) : Deferred<MBCTemperature>

    @GET(MBCUrls.SENSOR_BRIGHTNESS)
    fun getBrightnessState(@Path(MBCUrls.URL_PRM_ID) sId : String ) : Deferred<MBCBrightnessState>

    @GET(MBCUrls.SENSOR_PRESSURE)
    fun getPressureState(@Path(MBCUrls.URL_PRM_ID) sId : String ) : Deferred<MBCPressureState>

    @GET(MBCUrls.SENSOR_MOTION)
    fun getMotions(@Path(MBCUrls.URL_PRM_ID) sId : String ) : Deferred<MBCMotion>

    @GET(MBCUrls.SENSOR_LIGHT)
    fun getLightStatus(@Path(MBCUrls.URL_PRM_ID) sId : String ) : Deferred<MBCLightStates>

    @GET(MBCUrls.SENSOR_LIGHT_CHANGE_STATE)
    fun changeLightState(@Path(MBCUrls.URL_PRM_ID) sId : String,
                         @Path(MBCUrls.URL_PRM_COLOR) sColor : String,
                         @Path(MBCUrls.URL_PRM_STATUS) sState : String) : Deferred<MBCLightStates>

    @GET(MBCUrls.SENSOR_LIGHT)
    fun launchSapinOfDevil(@Path(MBCUrls.SENSOR_LIGHT_SAPIN_OF_DEVIL) sNumber : String ) : Deferred<MBCLightStates>
}