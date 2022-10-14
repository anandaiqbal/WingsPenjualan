package id.iglo.wingspenjualan.ui.checkout

import id.iglo.common.base.Constants

fun CheckoutFragment.sumSubTotal() {
    val totalPrice = vm.totalPrice.map {
        it.value
    }.sum()
    binding.totalPrice.text =
        String.format("Total : %s", (Constants.indonesiaCurrencyFormat.format(totalPrice)))
}