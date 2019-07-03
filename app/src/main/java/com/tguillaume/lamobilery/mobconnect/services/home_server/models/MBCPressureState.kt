package com.tguillaume.lamobilery.mobconnect.services.home_server.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MBCPressureState {

    @Expose
    @SerializedName("state_str")
    var mStateStr : String = ""

    @Expose
    @SerializedName("state")
    var mStateEnum : String = ""
}