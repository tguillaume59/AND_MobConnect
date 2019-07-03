package com.tguillaume.lamobilery.mobconnect.ui.sensors.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments.MBCBaseFragment
import com.tguillaume.lamobilery.mobconnect.ui.sensors.motion.viewmodels.MBCSensorMotionViewModel
import com.tguillaume.lamobilery.mobconnect.utils.bundle.MBCBundleKeys
import kotlinx.android.synthetic.main.fragment_sensor_motion.*

class MBCSensorMotionFragment : MBCBaseFragment() {

    private val mViewModel : MBCSensorMotionViewModel = MBCSensorMotionViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_sensor_motion, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.bindViewModel()
    }

    override fun bindViewModel() {
        super.subscribeToError(mViewModel)
        super.subscribeToLoader(mViewModel)

        mDisposeBag.add(mViewModel.mMotionState.subscribe{
            if(it) fragment_sensor_motion_card_title_textview.text = mContext.getString(R.string.fragment_sensor_motion_detect)
            else fragment_sensor_motion_card_title_textview.text = mContext.getString(R.string.fragment_sensor_motion_no_detect)
        })

        mDisposeBag.add(mViewModel.mLastDetectionDate.subscribe{
            fragment_sensor_motion_card_title_textview.text = "${mContext.getString(R.string.fragment_sensor_motion_no_detect)} $it"
        })

        arguments?.let {
            val tId : String = it.getString(MBCBundleKeys.ID_SENSOR, "")
            mViewModel.loadData(tId)
        }
    }
}