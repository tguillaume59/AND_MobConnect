package com.tguillaume.lamobilery.mobconnect.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tguillaume.bird.lib_bird_kotlin.adapters.recyclerview.GTADefaultViewHolder
import com.tguillaume.bird.lib_bird_kotlin.adapters.recyclerview.GTARecyclerViewAdapter
import com.tguillaume.bird.lib_bird_kotlin.adapters.recyclerview.GTARecyclerViewAdapterDelegate
import com.tguillaume.lamobilery.mobconnect.R
import com.tguillaume.lamobilery.mobconnect.services.home_server.models.MBCLinkedSensors
import com.tguillaume.lamobilery.mobconnect.services.sensors.managers.MBCUISensorManagerInterface
import com.tguillaume.lamobilery.mobconnect.ui.common.base_fragments.MBCBaseFragment
import com.tguillaume.lamobilery.mobconnect.ui.home.holders.MBCSensorsHolder
import com.tguillaume.lamobilery.mobconnect.ui.home.viewmodels.MBCHomeViewModel
import com.tguillaume.lamobilery.mobconnect.utils.bundle.MBCBundleKeys
import com.tguillaume.lamobilery.mobconnect.utils.navigation.managers.MBCSensorFragmentManagerInterface
import org.koin.android.ext.android.inject

class MBCHomeFragment : MBCBaseFragment(), GTARecyclerViewAdapterDelegate {

    private val mViewModel : MBCHomeViewModel = MBCHomeViewModel()
    private val mSensorUiManager : MBCUISensorManagerInterface by inject()
    private val mFragmentSensorManager : MBCSensorFragmentManagerInterface by inject()

    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mRecyclerViewAdapter: GTARecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rView : View = inflater.inflate(R.layout.fragment_home, container,false)

        mRecyclerView = rView.findViewById(R.id.fragment_home_recyclerview)

        val tLinearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(mContext)
        mRecyclerViewAdapter = GTARecyclerViewAdapter(this)
        mRecyclerView.layoutManager = tLinearLayoutManager
        mRecyclerView.adapter = mRecyclerViewAdapter

        return rView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.bindViewModel()
    }

    override fun bindViewModel() {
        super.subscribeToError(mViewModel)
        super.subscribeToLoader(mViewModel)

        mDisposeBag.add(mViewModel.mListLinkedSensors.subscribe{
            mRecyclerViewAdapter.notifyDataSetChanged()
        })

        mViewModel.loadData()
    }

    // ----------- RECYCLER VIEW ADAPTER ------------------
    override fun getItemCount(): Int {
        return mViewModel.mListLinkedSensors.value.size
    }

    override fun onBindViewHolder(holder: GTADefaultViewHolder?, position: Int) {
        if (position >= mViewModel.mListLinkedSensors.value.size) return
        if (holder == null || holder !is MBCSensorsHolder) return

        val tSensors: MBCLinkedSensors = mViewModel.mListLinkedSensors.value[position]

        holder.mSensorImageView.setImageDrawable(mSensorUiManager.getSensorPicture(mContext, tSensors.mType))
        holder.mSensorNameTextView.text = mSensorUiManager.getSensorName(mContext, tSensors.mType)

        holder.itemView.setOnClickListener {
            val tBundle = Bundle()
            tBundle.putString(MBCBundleKeys.ID_SENSOR, tSensors.mId)
            val tFragmentKey : String = mFragmentSensorManager.getFragmentKeyWithSensorType(tSensors.mType)
            mNavigationManager.showFragment(tFragmentKey, tBundle)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GTADefaultViewHolder {
        val tItemView = LayoutInflater.from(context).inflate(R.layout.holder_sensor_home, parent, false)
        return MBCSensorsHolder(tItemView)
    }
}