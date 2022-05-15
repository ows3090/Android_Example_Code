package ows.kotlinstudy.mvcexample.model.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ResultEntity(
    @PrimaryKey val result: String
)
