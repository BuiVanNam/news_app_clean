package com.nambv.demo.domain.model.base

/**
 * Created by nambv on 6/13/2021
 */
interface SectionTextModel : BaseContentSessionDetail {
    val text: String?
    val markups: List<MarkupTextModel?>?
}