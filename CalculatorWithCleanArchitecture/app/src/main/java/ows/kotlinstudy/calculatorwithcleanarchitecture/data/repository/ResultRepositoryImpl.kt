package ows.kotlinstudy.calculatorwithcleanarchitecture.data.repository

import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.repository.ResultRepository
import ows.kotlinstudy.mvcexample.model.db.dao.ResultDao
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class ResultRepositoryImpl(
    private val resultDao: ResultDao
): ResultRepository {
    override fun insertResult(resultEntity: ResultEntity) {
        resultDao.insertResult(resultEntity)
    }

    override fun getResultHistory(): List<ResultEntity> {
        return resultDao.getResultList()
    }
}