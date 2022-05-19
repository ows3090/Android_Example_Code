package ows.kotlinstudy.calculatorwithcleanarchitecture.domain.repository

import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

interface ResultRepository {
    fun insertResult(resultEntity: ResultEntity)
    fun getResultHistory(): List<ResultEntity>
}