package id.iglo.wingspenjualan.view_model

import android.app.Application
import dagger.hilt.android.lifecycle.HiltViewModel
import id.iglo.common.base.BaseViewModel
import id.iglo.wingspenjualan.ui.login.LoginFragmentDirections
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    fun toProduct() {
        navigate(
            LoginFragmentDirections.actionLoginFragmentToProductFragment(
            )
        )
    }
}