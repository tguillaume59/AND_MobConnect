package com.tguillaume.lamobilery.mobconnect.services.home_server.clients

import com.tguillaume.bird.lib_bird_kotlin.network.manager.GTANetworkManager
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.*
import com.tguillaume.lamobilery.mobconnect.utils.network.MBCUrlKeys
import kotlinx.coroutines.Deferred

class MBCHomeServerClient : MBCHomeServerClientIntefaces {

    override fun pingServer(): Deferred<Unit> {
        return GTANetworkManager.getAPI(MBCUrlKeys.HOME_SERVER_URL, MBCHomeServerClientIntefaces::class.java)
        .pingServer()
    }

    override fun getListLinkedSensors(): Deferred<MutableList<MBCLinkedSensors>> {
        return GTANetworkManager.getAPI(MBCUrlKeys.HOME_SERVER_URL, MBCHomeServerClientIntefaces::class.java)
                .getListLinkedSensors()
    }

    override fun getTemperature(sId: String): Deferred<MBCTemperature> {
        return GTANetworkManager.getAPI(MBCUrlKeys.HOME_SERVER_URL, MBCHomeServerClientIntefaces::class.java)
                .getTemperature(sId)
    }

    override fun getBrightnessState(sId: String): Deferred<MBCBrightnessState> {
        return GTANetworkManager.getAPI(MBCUrlKeys.HOME_SERVER_URL, MBCHomeServerClientIntefaces::class.java)
                .getBrightnessState(sId)
    }

    override fun getPressureState(sId: String): Deferred<MBCPressureState> {
        return GTANetworkManager.getAPI(MBCUrlKeys.HOME_SERVER_URL, MBCHomeServerClientIntefaces::class.java)
                .getPressureState(sId)
    }

    override fun getMotions(sId: String): Deferred<MBCMotion> {
        return GTANetworkManager.getAPI(MBCUrlKeys.HOME_SERVER_URL, MBCHomeServerClientIntefaces::class.java)
                .getMotions(sId)
    }
}