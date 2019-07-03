package com.tguillaume.lamobilery.mobconnect.services.home_server.clients

import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCLinkedSensors
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCTemperature
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
}