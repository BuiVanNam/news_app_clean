package com.nambv.demo.domain.model.base

/**
 * Created by nambv on 6/13/2021
 */
interface SectionVideoModel : BaseContentSessionDetail {
    val link: String?
    val caption: String?
    val duration: Long?
    val previewImage: SectionImageModel?
}