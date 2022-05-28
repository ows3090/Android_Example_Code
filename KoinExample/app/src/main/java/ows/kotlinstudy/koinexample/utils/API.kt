package ows.kotlinstudy.koinexample

import ows.kotlinstudy.koinexample.data.LiteKoinContext
import kotlin.reflect.KClass

fun getLiteKoin() = LiteKoinContext.getLiteKoin()

inline fun <reified T : Any> get(): T {
    val service = getLiteKoin().resolveInstance(T::class)
    return service.instance as T
}

inline fun <reified T : Any> inject(): Lazy<T> = lazy { get() }