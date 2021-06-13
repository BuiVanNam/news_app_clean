package com.nambv.demo.newsappdemo.ui.detail

import com.nambv.demo.domain.model.base.SectionImageModel
import com.nambv.demo.newsappdemo.databinding.ItemImageNewBinding
import com.nambv.demo.newsappdemo.utils.*

/**
 * Created by nambv on 6/13/2021
 */
class ImageDetailViewHolder(private val binding: ItemImageNewBinding) :
    BaseDetailNewInfoViewHolder<SectionImageModel>(binding) {

    override fun bindItem(content: SectionImageModel) {
        content.run {
            binding.captionImageNew.text = caption

            val sizeForView = itemView.context.getOverrideForSizeImageFullWidth(
                width ?: DEFAULT_SIZE_WIDTH_LOAD_IMAGE, height ?: DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
            )
            binding.imageDetail.apply {
                updateHeight(sizeForView[1])
                loadImage(
                    requestManager,
                    placeHolderDrawable,
                    placeHolderDrawable,
                    linkImage,
                    (sizeForView[0] * 0.5).toInt(),
                    (sizeForView[1] * 0.5).toInt()
                )
            }
        }
    }

}