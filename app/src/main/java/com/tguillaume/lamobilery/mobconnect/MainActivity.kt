package com.tguillaume.lamobilery.mobconnect

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tguillaume.bird.lib_bird_kotlin.navigation.GTANavigationManager
import com.tguillaume.bird.lib_bird_kotlin.navigation.interfaces.GTANavigationListener
import com.tguillaume.lamobilery.mobconnect.utils.navigation.MBCFragmentKeys

class MainActivity : AppCompatActivity(), GTANavigationListener {

    protected lateinit var mNavigationManager : GTANavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mNavigationManager = GTANavigationManager(this, R.id.activity_main_container_layout)
        showFragment(MBCFragmentKeys.CONFIG_SERVER)
    }

    override fun clearBackStack() {
        mNavigationManager.clearBackStack()
    }

    override fun showFragment(sEnum: String) {
        mNavigationManager.showFragment(sEnum)
    }

    override fun showFragment(sEnum: String, sBundle: Bundle) {
        mNavigationManager.showFragment(sEnum, sBundle)
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 1){
            super.onBackPressed()
        }
    }
}
