package id.iglo.wingspenjualan.ui.checkout

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import id.iglo.common.base.BaseFragment
import id.iglo.common.base.Constants
import id.iglo.common.ext.clear
import id.iglo.wingspenjualan.R
import id.iglo.wingspenjualan.databinding.CheckoutPageBinding
import id.iglo.wingspenjualan.view_model.SharedViewModel

@AndroidEntryPoint
class CheckoutFragment : BaseFragment<SharedViewModel, CheckoutPageBinding>() {

    override val layoutId: Int = R.layout.checkout_page
    override val vm: SharedViewModel by viewModels()
    private val adapter = CheckoutAdapter { product, subtotal ->
        vm.totalPrice[product] = subtotal
        sumSubTotal()
    }
    private val args by navArgs<CheckoutFragmentArgs>()

    override fun initBinding(binding: CheckoutPageBinding) {
        super.initBinding(binding)
        vm.loadSelectedProduct(args.product.toList())
        binding.checkoutList.adapter = adapter
        vm.selectedProduct.observe(this) { listProduct ->
            adapter.differ.submitList(listProduct)
            val totalPrice = listProduct.sumOf {
                Constants.discountPrice(it.price, it.discount)
            }
            listProduct.map {
                vm.totalPrice[it] = Constants.discountPrice(it.price, it.discount) * 1
            }
            binding.totalPrice.text =
                String.format("Total : %s", (Constants.indonesiaCurrencyFormat.format(totalPrice)))
        }
        binding.confirmButton.setOnClickListener {
            vm.popBack()
        }
    }
}