package id.iglo.common.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class ProductRoom(
    @PrimaryKey
    var productCode: String,
    @ColumnInfo(name = "product_name")
    var productName: String,
    @ColumnInfo(name = "price")
    val price: Long,
    @ColumnInfo(name = "currency")
    val currency: String,
    @ColumnInfo(name = "discount")
    val discount: Int,
    @ColumnInfo(name = "dimension")
    val dimension: String,
    @ColumnInfo(name = "unit")
    val unit: String,
)