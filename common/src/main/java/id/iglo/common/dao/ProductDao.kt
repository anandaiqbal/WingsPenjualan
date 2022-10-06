package id.iglo.common.dao

import androidx.room.Dao
import androidx.room.Query
import id.iglo.common.entity.ProductRoom

@Dao
interface ProductDao {
//    @Query("SELECT * FROM productroom")
//    val getAll: List<ProductRoom>

    @Query("SELECT * FROM productroom WHERE productCode IN (:productCode)")
    fun loadAllByIds(productCode: IntArray): List<ProductRoom>
}