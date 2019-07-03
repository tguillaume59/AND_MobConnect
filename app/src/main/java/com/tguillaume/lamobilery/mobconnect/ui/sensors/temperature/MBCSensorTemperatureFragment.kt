package com.tguillaume.lamobilery.mobconnect.ui.sensors.temperature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments.MBCBaseFragment
import com.tguillaume.lamobilery.mobconnect.ui.sensors.temperature.viewmodels.MBCSensorTemperatureViewModel
import com.tguillaume.lamobilery.mobconnect.utils.bundle.MBCBundleKeys
import kotlinx.android.synthetic.main.fragment_sensor_temperature.*

class MBCSensorTemperatureFragment : MBCBaseFragment() {

    private val mViewModel : MBCSensorTemperatureViewModel = MBCSensorTemperatureViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_sensor_temperature, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.bindViewModel()
    }

    override fun bindViewModel() {
        super.subscribeToError(mViewModel)
        super.subscribeToLoader(mViewModel)

        mDisposeBag.add(mViewModel.mTemperatureValue.subscribe{
            fragment_sensor_temperature_values_temperature_value.text = "$it°c"
        })

        mDisposeBag.add(mViewModel.mHumitityValue.subscribe{
            fragment_sensor_temperature_values_humidity_value_textview.text = "$it%"
        })

        arguments?.let {
            val tId : String = it.getString(MBCBundleKeys.ID_SENSOR, "")
            mViewModel.loadData(tId)
        }
    }
}