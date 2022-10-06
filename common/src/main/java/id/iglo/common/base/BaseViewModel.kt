package id.iglo.common.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavDirections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val navigationEvent = SingleLiveEvent<NavDirections>()
    val popBackEvent = SingleLiveEvent<Any>()

    fun navigate(navDirections: NavDirections){
        navigationEvent.postValue(navDirections)
    }

    fun popBack(){
        popBackEvent.postValue(Any())
    }

}