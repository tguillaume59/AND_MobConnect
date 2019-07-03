package com.tguillaume.lamobilery.mobconnect.ui.config_server

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tguillaume.bird.lib_bird_kotlin.viewmodels.GTAFragmentInterface
import com.tguillaume.lamobilery.mobconnect.BuildConfig
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments.MBCBaseFragment
import com.tguillaume.lamobilery.mobconnect.ui.config_server.viewmodels.MBCConfigServerViewModel
import kotlinx.android.synthetic.main.fragment_config_server.*

class MBCConfigServerFragment : MBCBaseFragment(), GTAFragmentInterface {

    val mViewModel : MBCConfigServerViewModel = MBCConfigServerViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_config_server, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.initOnClick()
        this.bindViewModel()

        if(BuildConfig.DEBUG) fragment_config_serveur_ip_edittext.setText("192.168.1.104:8081")
    }

    override fun bindViewModel() {
        super.subscribeToError(mViewModel)
        super.subscribeToLoader(mViewModel)

        mDisposeBag.add(mViewModel.mConfigServerSuccess.subscribe{ configSuccess : Boolean ->
            if(configSuccess){

            }
        })

        mViewModel.loadData()
    }

    private fun initOnClick(){
        fragment_config_server_validate_btn.setOnClickListener{this.onClickConfigure()}
    }

    private fun onClickConfigure(){
        val tIp : String = fragment_config_serveur_ip_edittext.text.toString()
        mViewModel.configureServer(tIp)
    }
}