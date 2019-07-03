package com.tguillaume.lamobilery.mobconnect.services.home_server.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MBCMotion {

    @Expose
    @SerializedName("status")
    var mStatus : Boolean = false

    @Expose
    @SerializedName("lastDetection")
    var mLastDetection : String = ""

    @Expose
    @SerializedName("lastDetectionIso")
    var mLastDetectionISO : String = ""
}