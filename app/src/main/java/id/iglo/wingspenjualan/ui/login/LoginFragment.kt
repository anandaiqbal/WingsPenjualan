package id.iglo.wingspenjualan.ui.login

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.iglo.common.base.BaseFragment
import id.iglo.wingspenjualan.R
import id.iglo.wingspenjualan.databinding.LoginPageBinding
import id.iglo.wingspenjualan.view_model.LoginViewModel

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, LoginPageBinding>() {
    override val layoutId: Int = R.layout.login_page
    override val vm: LoginViewModel by viewModels()
}