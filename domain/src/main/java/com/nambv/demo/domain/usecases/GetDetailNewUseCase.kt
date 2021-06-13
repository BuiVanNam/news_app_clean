package com.nambv.demo.domain.usecases

import com.nambv.demo.domain.common.BaseFlowUseCase
import com.nambv.demo.domain.model.detail.DetailNewInfoModel
import com.nambv.demo.domain.repositories.DetailNewRepository

/**
 * Created by nambv on 6/12/2021
 */
class GetDetailNewUseCase(
    private val detailNewRepository: DetailNewRepository
) : BaseFlowUseCase<DetailNewInfoModel>() {

    fun getDetailNewData() = invoke()

    override fun invoke() = detailNewRepository.getDetailNew()
}