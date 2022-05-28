package ows.kotlinstudy.koinexample.data

import kotlin.reflect.KClass

interface Service {
    val type: KClass<*>
    val instance: Any
}