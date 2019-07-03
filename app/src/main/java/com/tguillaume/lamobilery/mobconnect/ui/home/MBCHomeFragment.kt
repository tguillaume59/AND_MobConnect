package com.tguillaume.lamobilery.mobconnect.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments.MBCBaseFragment
import com.tguillaume.lamobilery.mobconnect.ui.home.viewmodels.MBCHomeViewModel

class MBCHomeFragment : MBCBaseFragment() {

    private val mViewModel : MBCHomeViewModel = MBCHomeViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.bindViewModel()
    }

    override fun bindViewModel() {
        super.subscribeToError(mViewModel)
        super.subscribeToLoader(mViewModel)

        mDisposeBag.add(mViewModel.mListLinkedSensors.subscribe{

        })

        mViewModel.loadData()
    }
}