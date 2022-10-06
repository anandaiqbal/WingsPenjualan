package id.iglo.wingspenjualan.ui.product

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.iglo.common.base.BaseFragment
import id.iglo.wingspenjualan.R
import id.iglo.wingspenjualan.databinding.ProductListPageBinding
import id.iglo.wingspenjualan.view_model.SharedViewModel

@AndroidEntryPoint
class ProductFragment : BaseFragment<SharedViewModel, ProductListPageBinding>() {

    override val layoutId: Int = R.layout.product_list_page
    override val vm: SharedViewModel by viewModels()
    val adapter = ProductAdapter(::startActionMode, {
        vm.selection.value.orEmpty()
    }, ::toggleClick)

    override fun initBinding(binding: ProductListPageBinding) {
        super.initBinding(binding)
        vm.loadProductData()
        binding.productRecycler.adapter = adapter
        vm.productData.observe(this) {
            adapter.differ.submitList(it)
        }
        binding.checkoutButton.setOnClickListener {
            vm?.selection?.value?.let {
                checkoutButton(it)
            }
        }
    }
}