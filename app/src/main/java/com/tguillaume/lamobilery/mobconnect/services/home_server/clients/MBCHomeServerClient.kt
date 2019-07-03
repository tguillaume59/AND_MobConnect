package com.tguillaume.lamobilery.mobconnect.services.home_server.clients

import com.tguillaume.bird.lib_bird_kotlin.network.manager.GTANetworkManager
import com.tguillaume.lamobilery.mobconnect.utils.network.MBCUrlKeys
import kotlinx.coroutines.Deferred

class MBCHomeServerClient : MBCHomeServerClientIntefaces {
    override fun pingServer(): Deferred<Unit> {
        return GTANetworkManager.getAPI(MBCUrlKeys.HOME_SERVER_URL, MBCHomeServerClientIntefaces::class.java)
        .pingServer()
    }
}