package com.tguillaume.lamobilery.mobconnect.utils.errors

import android.content.Context
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.lamobilery.mobconnect.R

object MBCMappingErrors {

    fun initErrorMap(sContext : Context){

        GTAErrorManager.registerNewError(MBCErrorKeys.SERVER_IP_EMPTY, sContext.getString(R.string.error_server_ip_empty))
    }
}