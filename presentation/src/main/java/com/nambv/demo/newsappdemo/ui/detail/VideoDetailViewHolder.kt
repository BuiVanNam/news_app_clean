package com.nambv.demo.newsappdemo.ui.detail

import com.nambv.demo.domain.model.base.SectionVideoModel
import com.nambv.demo.newsappdemo.databinding.ItemVideoNewBinding
import com.nambv.demo.newsappdemo.utils.*

/**
 * Created by nambv on 6/13/2021
 */
class VideoDetailViewHolder(private val binding: ItemVideoNewBinding) :
    BaseDetailNewInfoViewHolder<SectionVideoModel>(binding) {

    override fun bindItem(content: SectionVideoModel) {
        content.run {
            binding.captionVideoNew.text = caption
            val sizeForView = itemView.context.getOverrideForSizeImageFullWidth(
                previewImage?.width ?: DEFAULT_SIZE_WIDTH_LOAD_IMAGE,
                previewImage?.height ?: DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
            )
            binding.thumbVideoDetail.apply {
                updateHeight(sizeForView[1])
                loadImage(
                    requestManager,
                    placeHolderDrawable,
                    placeHolderDrawable,
                    previewImage?.linkImage,
                    (sizeForView[0] * 0.5).toInt(),
                    (sizeForView[1] * 0.5).toInt()
                )
            }

        }
    }

}