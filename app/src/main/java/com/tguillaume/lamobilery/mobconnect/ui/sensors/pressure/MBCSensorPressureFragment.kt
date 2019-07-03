package com.tguillaume.lamobilery.mobconnect.ui.sensors.pressure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments.MBCBaseFragment
import com.tguillaume.lamobilery.mobconnect.ui.sensors.pressure.viewmodels.MBCSensorPressureViewModel
import com.tguillaume.lamobilery.mobconnect.utils.bundle.MBCBundleKeys
import kotlinx.android.synthetic.main.fragment_sensor_pressure.*

class MBCSensorPressureFragment : MBCBaseFragment() {

    private val mViewModel : MBCSensorPressureViewModel = MBCSensorPressureViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_sensor_pressure, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.bindViewModel()
    }

    override fun bindViewModel() {
        super.subscribeToError(mViewModel)
        super.subscribeToLoader(mViewModel)

        mDisposeBag.add(mViewModel.mPressureState.subscribe{
            fragment_sensor_pressure_value_textview.text = it
        })

        arguments?.let {
            val tId : String = it.getString(MBCBundleKeys.ID_SENSOR, "")
            mViewModel.loadData(tId)
        }
    }
}