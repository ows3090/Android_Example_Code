package ows.kotlinstudy.koinexample

import ows.kotlinstudy.koinexample.data.Module


fun module(block: Module.() -> Unit) = Module().apply(block)