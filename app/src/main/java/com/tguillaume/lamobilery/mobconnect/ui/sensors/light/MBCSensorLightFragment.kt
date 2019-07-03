package com.tguillaume.lamobilery.mobconnect.ui.sensors.light

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments.MBCBaseFragment
import com.tguillaume.lamobilery.mobconnect.ui.sensors.light.viewmodels.MBCSensorLightViewmodel
import com.tguillaume.lamobilery.mobconnect.utils.bundle.MBCBundleKeys
import kotlinx.android.synthetic.main.fragment_sensor_light.*

class MBCSensorLightFragment : MBCBaseFragment() {

    private val mViewModel : MBCSensorLightViewmodel = MBCSensorLightViewmodel()
    private var mId : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_sensor_light, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.bindViewModel()
        this.initOnClick()
    }

    override fun bindViewModel() {
        super.subscribeToError(mViewModel)
        super.subscribeToLoader(mViewModel)

        mDisposeBag.add(mViewModel.mLedGreenState.subscribe{
            if(it)fragment_sensor_light_led_green_state_textview.text = mContext.getString(R.string.light_state_turn_on)
            else fragment_sensor_light_led_green_state_textview.text = mContext.getString(R.string.light_state_turn_off)
        })

        mDisposeBag.add(mViewModel.mLedRedState.subscribe{
            if(it)fragment_sensor_light_led_red_state_textview.text = mContext.getString(R.string.light_state_turn_on)
            else fragment_sensor_light_led_red_state_textview.text = mContext.getString(R.string.light_state_turn_off)
        })

        arguments?.let {
            mId = it.getString(MBCBundleKeys.ID_SENSOR, "")
            mViewModel.loadData(mId)
        }
    }

    private fun initOnClick(){
        fragment_sensor_light_led_green_state_textview.setOnClickListener{this.onClickGreenLed()}
        fragment_sensor_light_led_red_state_textview.setOnClickListener{this.onClickRedLed()}
    }

    private fun onClickRedLed(){
        mViewModel.changeRedLed(mId)
    }

    private fun onClickGreenLed(){
        mViewModel.changeGreenLed(mId)
    }
}