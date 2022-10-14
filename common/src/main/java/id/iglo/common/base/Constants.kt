package id.iglo.common.base

import java.text.DecimalFormat
import java.util.*

object Constants {
    val indonesiaCurrencyFormat = DecimalFormat.getCurrencyInstance(Locale("id", "ID"))
    fun discountPrice(price: Long, discount: Int) : Long {
        val price = (price - (price * discount / 100))
        return price
    }
}