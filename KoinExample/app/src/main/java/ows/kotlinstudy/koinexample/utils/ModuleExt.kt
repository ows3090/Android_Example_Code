package ows.kotlinstudy.koinexample

import ows.kotlinstudy.koinexample.data.Declaration
import ows.kotlinstudy.koinexample.data.Module
import kotlin.reflect.KClass


val List<Module>.declarationRegistry: Map<KClass<*>, Declaration<Any>>
    get() = this.fold(this[0].declarationRegistry) { acc, module ->
        (acc + module.declarationRegistry) as MutableMap<KClass<*>, Declaration<Any>>
    }