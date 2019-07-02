package com.tguillaume.lamobilery.mobconnect

import android.app.Application
import com.facebook.stetho.Stetho
import com.tguillaume.lamobilery.mobconnect.depencies_injection.DependencyInjectionModules
import com.tguillaume.lamobilery.mobconnect.utils.errors.MBCMappingErrors
import com.tguillaume.lamobilery.mobconnect.utils.navigation.MBCMapingFragments
import org.koin.android.ext.android.startKoin

class MBCApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Koin
        startKoin(this, listOf(DependencyInjectionModules))

        //Stethos
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

        //initialisation de la navigation
        MBCMapingFragments.initMapFragment()

        //initialisation des erreurs
        MBCMappingErrors.initErrorMap(this)
    }
}