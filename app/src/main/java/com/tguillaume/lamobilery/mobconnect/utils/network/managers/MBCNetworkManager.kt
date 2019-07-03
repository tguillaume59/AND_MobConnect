package com.tguillaume.lamobilery.mobconnect.utils.network.managers

import android.content.Context
import android.util.Log
import com.tguillaume.bird.lib_bird_kotlin.network.manager.GTANetworkManager
import com.tguillaume.lamobilery.mobconnect.utils.network.MBCUrlKeys
import okhttp3.Interceptor
import java.lang.Exception
import java.lang.NullPointerException

class MBCNetworkManager : MBCNetworkManagerInterface {

    private val TAG : String = MBCNetworkManager::class.java.simpleName

    private lateinit var mContext : Context

    override fun initManager(sContext : Context){
        Log.i(TAG, "initManager")
        this.mContext = sContext
    }

    override fun initNetwork(sIp : String , sWithLog : Boolean){
        Log.i(TAG, "initNetwork -> IP serveur = $sIp")
        try {
            val tUrl = "http://$sIp"
            val tMapKeyUrl: MutableMap<String, String> = HashMap()
            val tMapInterceptors : MutableMap<String, MutableList<Interceptor>> = HashMap()

            tMapKeyUrl.put(MBCUrlKeys.HOME_SERVER_URL, tUrl)

            GTANetworkManager.initManager(sContext = mContext,
                    sWithCache = true,
                    sMapUrl = tMapKeyUrl,
                    sWithLog = sWithLog,
                    sMapInterceptor = tMapInterceptors)

        }catch (e : NullPointerException){
            Log.e(TAG, "[EXCEPTION] Vous devez d'abord initialiser le context avec la méthode initManager dans la classe application")

        }catch (e : Exception){
            Log.e(TAG, "[EXCEPTION] ${e.message}")
        }
    }
}