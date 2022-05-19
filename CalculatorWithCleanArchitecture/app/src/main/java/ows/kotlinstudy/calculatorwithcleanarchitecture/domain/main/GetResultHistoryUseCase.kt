package ows.kotlinstudy.calculatorwithcleanarchitecture.domain.main

import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.repository.ResultRepository
import ows.kotlinstudy.calculatorwithcleanarchitecture.domain.usecase.UseCase
import ows.kotlinstudy.mvcexample.model.db.dao.ResultDao
import ows.kotlinstudy.mvcexample.model.db.entity.ResultEntity

class GetResultHistoryUseCase(
    private val resultRepository: ResultRepository
) : UseCase {

    operator fun invoke(): List<ResultEntity> {
        return resultRepository.getResultHistory()
    }
}