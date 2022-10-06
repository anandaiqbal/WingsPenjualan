package id.iglo.wingspenjualan.ui.checkout

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import id.iglo.common.base.BaseFragment
import id.iglo.wingspenjualan.R
import id.iglo.wingspenjualan.databinding.CheckoutPageBinding
import id.iglo.wingspenjualan.view_model.SharedViewModel

@AndroidEntryPoint
class CheckoutFragment : BaseFragment<SharedViewModel, CheckoutPageBinding>() {

    override val layoutId: Int = R.layout.checkout_page
    override val vm: SharedViewModel by viewModels()
    private val adapter = CheckoutAdapter()
    private val args by navArgs<CheckoutFragmentArgs>()

    override fun initBinding(binding: CheckoutPageBinding) {
        super.initBinding(binding)
        vm.loadSelectedProduct(args.product.toList())
        binding.totalPrice.text = String.format("Total : Rp.%s", args.product.map {
            it.price
        }.sum().toString())
        binding.checkoutList.adapter = adapter
        vm.selectedProduct.observe(this) {
            adapter.differ.submitList(it)
        }
    }
}