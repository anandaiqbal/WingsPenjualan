package id.iglo.api_service.usecase

import id.iglo.common.entity.Product
import kotlinx.coroutines.flow.flow

class ProductUseCase {
    operator fun invoke() = flow {
        val product = arrayListOf<Product>(
            Product("SKUSKILNP","So klin Pewangi", 15000, "IDR",
                10, "13 cm x 10 cm", "PCS"),
            Product("GVBR","Giv Biru", 11000, "IDR",
                10, "13 cm x 10 cm", "PCS"),
            Product("SKUSKILNL","So klin Liquid", 18000, "IDR",
                10, "13 cm x 10 cm", "PCS"),
            Product("GVKG","Giv Kuning", 10000, "IDR",
                10, "13 cm x 10 cm", "PCS"),
            Product("GVUG","Giv Ungu", 12000, "IDR",
                10, "13 cm x 10 cm", "PCS")
        )
        emit(product)
    }
}