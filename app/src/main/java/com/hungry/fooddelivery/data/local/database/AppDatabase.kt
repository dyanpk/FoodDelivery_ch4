package com.hungry.fooddelivery.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hungry.fooddelivery.data.dummy.DummyMenuDataSourceImpl
import com.hungry.fooddelivery.data.local.database.AppDatabase.Companion.getInstance
import com.hungry.fooddelivery.data.local.database.dao.CartDao
import com.hungry.fooddelivery.data.local.database.dao.MenuDao
import com.hungry.fooddelivery.data.local.database.entity.CartEntity
import com.hungry.fooddelivery.data.local.database.entity.MenuEntity
import com.hungry.fooddelivery.data.local.database.mapper.toMenuEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Database(
    entities = [MenuEntity::class, CartEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun MenuDao() : MenuDao
    abstract fun cartDao(): CartDao

    companion object{
        private const val DB_NAME = "FoodDelivery.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .addCallback(DatabaseSeederCallback(context))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

class DatabaseSeederCallback(private val context: Context) : RoomDatabase.Callback() {
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        scope.launch {
            getInstance(context).MenuDao().insertMenus(prepopulateMenus())
            getInstance(context).cartDao().insertCarts(prepopulateCarts())
        }
    }


    private fun prepopulateMenus(): List<MenuEntity> {
        return DummyMenuDataSourceImpl().getMenu().toMenuEntity()
    }

    private fun prepopulateCarts(): List<CartEntity> {
        return mutableListOf(
            CartEntity(
                id = 1,
                menuId = 1,
                itemNotes = "Extra saus",
                itemQuantity = 3
            ),
            CartEntity(
                id = 2,
                menuId = 2,
                itemNotes = "extra saus",
                itemQuantity = 6
            ),
        )
    }

}