package com.tguillaume.lamobilery.mobconnect

import android.app.Application
import com.facebook.stetho.Stetho
import com.tguillaume.lamobilery.mobconnect.depencies_injection.DependencyInjectionModules
import org.koin.android.ext.android.startKoin

class MBCApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Koin
        startKoin(this, listOf(DependencyInjectionModules))

        //Stethos
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

    }
}