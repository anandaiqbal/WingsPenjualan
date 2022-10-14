package id.iglo.wingspenjualan.view_model

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.lifecycle.HiltViewModel
import id.iglo.api_service.usecase.ProductUseCase
import id.iglo.common.base.BaseViewModel
import id.iglo.common.entity.Product
import id.iglo.wingspenjualan.ui.login.LoginFragmentDirections
import id.iglo.wingspenjualan.ui.product.ProductFragmentDirections
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    application: Application,
    val productUseCase: ProductUseCase
) :
    BaseViewModel(application) {

    val productData = MutableLiveData<ArrayList<Product>>()

    val selection = MutableLiveData<ArrayList<Product>>()

    var selectedProduct = MutableLiveData<List<Product>>()
    var selectedProduct2 = MutableLiveData<Product>()

    val totalPrice = mutableMapOf<Product, Long>()

    fun loadProductData() {
        viewModelScope.launch {
            productUseCase().collect {
                productData.postValue(it)
            }
        }
    }

    fun loadSelectedProduct(product: List<Product>) {
        viewModelScope.launch {
            selectedProduct.postValue(product)
        }
    }

    fun loadDetailProduct(product: Product) {
        viewModelScope.launch {
            selectedProduct2.postValue(product)
        }
    }

    fun toDetail(products: Product) {
        navigate(
            ProductFragmentDirections.actionProductFragmentToProductDetailFragment(
                products
            )
        )
    }

    fun toCheckout(products: ArrayList<Product>) {
        navigate(
            ProductFragmentDirections.actionProductFragmentToCheckoutFragment(
                products.toTypedArray()
            )
        )
    }

}