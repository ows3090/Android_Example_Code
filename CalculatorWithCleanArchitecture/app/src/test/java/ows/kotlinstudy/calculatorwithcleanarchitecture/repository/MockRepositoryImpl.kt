package ows.kotlinstudy.calculatorwithcleanarchitecture.repository

import ows.kotlinstudy.calculatorwithcleanarchitecture.data.repository.ResultRepositoryImpl
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.repository.ResultRepository
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class MockRepositoryImpl : ResultRepository {
    override fun insertResult(resultEntity: ResultEntity) = Unit

    override fun getResultHistory(): List<ResultEntity> = listOf()
}