package ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main

import androidx.lifecycle.LiveData
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.UseCase
import ows.kotlinstudy.mvcexample.model.db.dao.ResultDao
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class GetResultHistoryUseCase(
    private val resultDao: ResultDao
) : UseCase {

    operator fun invoke(): List<ResultEntity> {
        return resultDao.getResultList()
    }
}