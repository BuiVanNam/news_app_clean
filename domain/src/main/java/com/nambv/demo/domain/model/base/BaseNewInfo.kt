package com.nambv.demo.domain.model.base

/**
 * Created by nambv on 6/13/2021
 */
interface BaseNewInfo {
    val documentId: String?
    val title: String?
    val description: String?
    val publishedDate: String?
    val originUrl: String?
    val publisherNewModel: PublisherNewModel?
}