package com.tguillaume.lamobilery.mobconnect.services.home_server.clients

import com.tguillaume.lamobilery.mobconnect.utils.network.MBCUrls
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MBCHomeServerClientIntefaces {

    @GET(MBCUrls.PING_SERVER)
    fun pingServer() : Deferred<Unit>

}