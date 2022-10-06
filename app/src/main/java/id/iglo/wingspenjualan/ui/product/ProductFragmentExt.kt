package id.iglo.wingspenjualan.ui.product

import android.view.ActionMode
import id.iglo.common.entity.Product
import id.iglo.common.ext.toggle

var actionMode: ActionMode? = null

fun ProductFragment.toggleClick(product: Product) {
    actionMode?.let {
        adapter.toggleSelection(product) {
            vm.selection.toggle(product)
        }
    } ?: run {
        detailButton(product)
    }
}


fun ProductFragment.startActionMode(product: Product) {
    adapter.toggleSelection(product) {
        vm.selection.toggle(product)
    }
}

fun ProductFragment.checkoutButton(list: ArrayList<Product>) {
    vm.toCheckout(list)
    val totalPrice = list.map {
        it.price
    }
}

fun ProductFragment.detailButton(product: Product) {
    vm.toDetail(product)
}