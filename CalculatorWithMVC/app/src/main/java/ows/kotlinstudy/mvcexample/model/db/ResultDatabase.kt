package ows.kotlinstudy.mvcexample.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ows.kotlinstudy.mvcexample.model.db.dao.ResultDao
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

@Database(
    entities = [ResultEntity::class],
    version = 1
)
abstract class ResultDatabase: RoomDatabase() {
    abstract fun resultDao(): ResultDao

    companion object{
        const val DB_NAME = "Result.db"

        fun build(context: Context): ResultDatabase = Room.databaseBuilder(
            context,
            ResultDatabase::class.java,
            DB_NAME
        ).allowMainThreadQueries().build()
    }
}