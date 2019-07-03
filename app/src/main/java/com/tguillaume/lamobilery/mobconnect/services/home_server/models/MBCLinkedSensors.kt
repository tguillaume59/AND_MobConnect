package com.tguillaume.lamobilery.mobconnect.services.home_server.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MBCLinkedSensors {

    @Expose
    @SerializedName("id")
    var mId : String = ""

    @Expose
    @SerializedName("type")
    var mType : String = ""
}