package id.iglo.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import id.iglo.common.dao.ProductDao
import id.iglo.common.entity.ProductRoom

@Database(entities = [ProductRoom::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}