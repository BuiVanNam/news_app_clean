package com.nambv.demo.domain.model.base

/**
 * Created by nambv on 6/13/2021
 */
interface SectionImageModel : BaseContentSessionDetail {
    val linkImage: String?
    val mainColor: String?
    val width: Int?
    val height: Int?
    val caption: String?
}