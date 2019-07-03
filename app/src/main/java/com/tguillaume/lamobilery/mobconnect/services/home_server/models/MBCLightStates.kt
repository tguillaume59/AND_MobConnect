package com.tguillaume.lamobilery.mobconnect.services.home_server.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MBCLightStates {

    @Expose
    @SerializedName("rouge")
    var mRedLED : Boolean = false

    @Expose
    @SerializedName("verte")
    var mGreenLED : Boolean = false
}