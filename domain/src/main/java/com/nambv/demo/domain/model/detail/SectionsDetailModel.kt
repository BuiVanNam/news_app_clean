package com.nambv.demo.domain.model.detail

import com.nambv.demo.domain.model.base.BaseContentSessionDetail

/**
 * Created by nambv on 6/13/2021
 */
data class SectionsDetailModel(
    val sectionType: TypeSessionNew,
    val content: BaseContentSessionDetail
)