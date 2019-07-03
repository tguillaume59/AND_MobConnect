package com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.bird.lib_bird_kotlin.navigation.defaultFragments.GTAFragment
import com.tguillaume.bird.lib_bird_kotlin.navigation.interfaces.GTANavigationListener
import com.tguillaume.bird.lib_bird_kotlin.sharedPreferences.GTASharedPrefManager
import com.tguillaume.bird.lib_bird_kotlin.sharedPreferences.GTASharedPrefManagerInterface
import com.tguillaume.bird.lib_bird_kotlin.viewmodels.GTAFragmentInterface
import com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels.MBCBaseViewModel
import com.tguillaume.lamobilery.mobconnect.ui.common.listeners.MBCLoaderListener
import com.tguillaume.lamobilery.mobconnect.utils.errors.MBCErrorKeys
import com.tguillaume.lamobilery.mobconnect.utils.shared_prefs.MBCSharedPrefKeys

abstract class MBCBaseFragment : GTAFragment(), GTAFragmentInterface {

    protected lateinit var mContext: Context
    protected lateinit var mSharedPrefManager: GTASharedPrefManagerInterface
    protected lateinit var mNavigationManager: GTANavigationListener
    protected lateinit var mLoaderManager: MBCLoaderListener
    protected val mErrorManager = GTAErrorManager

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            mContext = it
            mNavigationManager = mContext as GTANavigationListener
            mLoaderManager = mContext as MBCLoaderListener
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        init()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    open fun init() {
        mSharedPrefManager = GTASharedPrefManager(mContext, MBCSharedPrefKeys.SHARED_PREF_NAME)
        mLoaderManager.hideLoader()
    }

    protected fun subscribeToError(sViewModel : MBCBaseViewModel){
        mDisposeBag.add(sViewModel.mError.subscribe{ sError : GTAError ->
            if( ! MBCErrorKeys.NULL.equals(sError.mCode)) {
                this.displayError(sError)
                sViewModel.mError.onNext(GTAError(sMessage ="", sCode = MBCErrorKeys.NULL))
            }
        })
    }

    protected fun subscribeToLoader(sViewModel: MBCBaseViewModel){
        mDisposeBag.add(sViewModel.mShouldDisplayLoader.subscribe{sShouldDisplay : Boolean ->
            if(sShouldDisplay) mLoaderManager.showLoader()
            else mLoaderManager.hideLoader()
        })
    }

    protected fun displayError(sError : GTAError){
        Toast.makeText(mContext, sError.mMessage, Toast.LENGTH_SHORT).show()
    }
}