package es.thalos.odiseo.mvp

import es.thalos.odiseo.mvp.core.base.BaseViewModel
import es.thalos.odiseo.mvp.core.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

class FirstViewModel @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    coroutineExceptionHandler: CoroutineExceptionHandler
): BaseViewModel(
    coroutineExceptionHandler,
    dispatcher
) {
    fun getQrCode(){

    }
}
