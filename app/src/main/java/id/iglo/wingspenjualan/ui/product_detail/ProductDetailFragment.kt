package id.iglo.wingspenjualan.ui.product_detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import id.iglo.common.base.BaseFragment
import id.iglo.wingspenjualan.R
import id.iglo.wingspenjualan.databinding.ProductDetailPageBinding
import id.iglo.wingspenjualan.view_model.SharedViewModel

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<SharedViewModel, ProductDetailPageBinding>() {

    override val layoutId: Int = R.layout.product_detail_page
    override val vm: SharedViewModel by viewModels()
    private val args by navArgs<ProductDetailFragmentArgs>()

    override fun initBinding(binding: ProductDetailPageBinding) {
        super.initBinding(binding)
        vm.loadDetailProduct(args.product)
        vm.selectedProduct2.observe(this) {
            binding.data = it
        }
    }
}