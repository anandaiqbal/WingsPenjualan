package id.iglo.api_service.usecase

import id.iglo.common.entity.Product
import kotlinx.coroutines.flow.flow

class ProductUseCase {
    operator fun invoke() = flow {
        val product = arrayListOf<Product>(
            Product(
                "SKUSKILNP", "So klin Pewangi", 15000, "IDR",
                10, "13 cm x 10 cm", "PCS"
            ),
            Product(
                "GVBR", "Giv Biru", 11000, "IDR",
                10, "13 cm x 10 cm", "PCS"
            ),
            Product(
                "SKUSKILNL", "So klin Liquid", 18000, "IDR",
                10, "13 cm x 10 cm", "PCS"
            ),
            Product(
                "GVKG", "Giv Kuning", 10000, "IDR",
                10, "13 cm x 10 cm", "PCS"
            ),
            Product(
                "GVUG", "Giv Ungu", 12000, "IDR",
                10, "13 cm x 10 cm", "PCS"
            ),
            Product(
                "MIESDPG", "Mie Sedap Goreng", 4000, "IDR",
                0, "20 cm x 10 cm", "PCS"
            ),
            Product(
                "MIESDPR", "Mie Sedap Rebus", 4000, "IDR",
                0, "20 cm x 10 cm", "PCS"
            ),
            Product(
                "CPTDNTHJ", "Ciptadent Hijau", 12000, "IDR",
                15, "17 cm x 5 cm", "PCS"
            ),
            Product(
                "CPTDNTPNK", "Ciptadent Pink", 12000, "IDR",
                20, "17 cm x 5 cm", "PCS"
            )
        )
        emit(product)
    }
}