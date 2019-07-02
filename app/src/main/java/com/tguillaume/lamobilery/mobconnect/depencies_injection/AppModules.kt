package com.tguillaume.lamobilery.mobconnect.depencies_injection

import com.tguillaume.bird.lib_bird_kotlin.sharedPreferences.GTASharedPrefManager
import com.tguillaume.bird.lib_bird_kotlin.sharedPreferences.GTASharedPrefManagerInterface
import com.tguillaume.lamobilery.mobconnect.utils.shared_prefs.MBCSharedPrefKeys.SHARED_PREF_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * @Project : AND_Moha_Legion
 *
 * AppModules.kt
 *
 * Created by TARTARA Guillaume on 2019-07-02
 * Copyright © 2019 tguillaume. All rights reserved.
 */
val DependencyInjectionModules = module {

    factory<GTASharedPrefManagerInterface> { GTASharedPrefManager(this.androidContext(), SHARED_PREF_NAME)}

}