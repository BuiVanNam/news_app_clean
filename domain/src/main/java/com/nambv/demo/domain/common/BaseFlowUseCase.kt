package com.nambv.demo.domain.common

import kotlinx.coroutines.flow.Flow

/**
 * Created by nambv on 6/12/2021
 */
abstract class BaseFlowUseCase<R> {

    protected abstract fun invoke(): Flow<ResourceData<out R>>

}
