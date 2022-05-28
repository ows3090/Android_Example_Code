package ows.kotlinstudy.koinexample

import ows.kotlinstudy.koinexample.data.Declaration
import ows.kotlinstudy.koinexample.data.DefaultService
import ows.kotlinstudy.koinexample.data.Service


fun <T:Any> Declaration<T>.toService(): Service {
    val instance = this()
    return DefaultService.createService(instance)
}