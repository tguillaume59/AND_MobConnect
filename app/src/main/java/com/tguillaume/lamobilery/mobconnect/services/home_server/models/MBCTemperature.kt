package com.tguillaume.lamobilery.mobconnect.services.home_server.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MBCTemperature {

    @Expose
    @SerializedName("temperature")
    var mTemperature : Double = 0.0

    @Expose
    @SerializedName("humidity")
    var mHumidity : Double = 0.0
}