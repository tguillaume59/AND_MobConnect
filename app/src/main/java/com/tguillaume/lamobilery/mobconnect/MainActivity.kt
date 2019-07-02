package com.tguillaume.lamobilery.mobconnect

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.tguillaume.bird.lib_bird_kotlin.navigation.GTANavigationManager
import com.tguillaume.bird.lib_bird_kotlin.navigation.interfaces.GTANavigationListener
import com.tguillaume.lamobilery.mobconnect.ui.common.listeners.MBCLoaderListener
import com.tguillaume.lamobilery.mobconnect.utils.navigation.MBCFragmentKeys

class MainActivity : AppCompatActivity(), GTANavigationListener, MBCLoaderListener {

    protected lateinit var mLoaderLayout: RelativeLayout
    protected lateinit var mNavigationManager : GTANavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mLoaderLayout = this.findViewById(R.id.activity_main_loader_layout)
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

    override fun showLoader() {
        mLoaderLayout.setVisibility(View.VISIBLE)
    }

    override fun hideLoader() {
        mLoaderLayout.setVisibility(View.GONE)
    }
}
