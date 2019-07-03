package com.tguillaume.lamobilery.mobconnect.ui.common.base_viewmodels

import com.tguillaume.bird.lib_bird_kotlin.errors.GTAError
import com.tguillaume.bird.lib_bird_kotlin.errors.GTAErrorManager
import com.tguillaume.bird.lib_bird_kotlin.viewmodels.GTAViewModelInterface
import com.tguillaume.lamobilery.mobconnect.utils.errors.MBCErrorKeys
import io.reactivex.subjects.BehaviorSubject
import org.koin.standalone.KoinComponent

abstract class MBCBaseViewModel : KoinComponent, GTAViewModelInterface {

    var mError : BehaviorSubject<GTAError> = BehaviorSubject.createDefault(GTAError("", MBCErrorKeys.NULL))
    var mShouldDisplayLoader : BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)

    override fun loadData() {

    }

    /**
     * Permet de notifier qu'il faut afficher l'erreur par défaut
     */
    protected fun onNextDefaultError(){
        this.mError.onNext(GTAErrorManager.getErrorByCode(MBCErrorKeys.DEFAULT))
    }
}