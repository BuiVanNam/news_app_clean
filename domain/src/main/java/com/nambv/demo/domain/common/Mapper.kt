package com.nambv.demo.domain.common

/**
 * Created by nambv on 6/12/2021
 */
interface Mapper<in From, To> {
    fun mapModel(from: From): To
}