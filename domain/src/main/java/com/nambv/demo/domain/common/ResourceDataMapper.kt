package com.nambv.demo.domain.common

/**
 * Created by nambv on 6/12/2021
 */
abstract class ResourceDataMapper<From, To> : Mapper<ResourceData<From>, ResourceData<To>> {

    override fun mapModel(from: ResourceData<From>): ResourceData<To> {
        return when (from) {
            is ResourceData.Success -> ResourceData.Success(mapModelResource(from = from.data)!!)
            is ResourceData.Error -> ResourceData.Error(
                mapModelResource(from = from.data),
                message = from.message
            )
            is ResourceData.Loading -> ResourceData.Loading(
                mapModelResource(from = from.data)
            )
        }
    }

    abstract fun mapModelResource(from: From?): To?


}