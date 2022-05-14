package ows.kotlinstudy.mvcexample.model.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

@Dao
interface ResultDao {

    @Query("SELECT * FROM ResultEntity")
    fun getResultList(): List<ResultEntity>

    @Insert
    fun insertResult(resultEntity: ResultEntity)
}