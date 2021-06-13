package com.nambv.demo.newsappdemo.ui.feed

import android.annotation.SuppressLint
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.newsappdemo.databinding.ItemNewVideoBinding
import com.nambv.demo.newsappdemo.utils.DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
import com.nambv.demo.newsappdemo.utils.DEFAULT_SIZE_WIDTH_LOAD_IMAGE

/**
 * Created by nambv on 6/13/2021
 */
class VideoNewInfoViewHolder(private val binding: ItemNewVideoBinding) :
    BaseNewInfoViewHolder(binding) {

    @SuppressLint("SetTextI18n")
    override fun bindItem(newInfo: NewInfoModel) {
        newInfo.run {

            binding.titleNew.text = title
            binding.publisherNew.text = publisherNewModel?.name + " . " + publishedDate

            requestManager
                .load(mainImage)
                .placeholder(placeHolderDrawable)
                .error(placeHolderDrawable)
                .override(DEFAULT_SIZE_WIDTH_LOAD_IMAGE, DEFAULT_SIZE_HEIGHT_LOAD_IMAGE)
                .centerCrop()
                .into(binding.thumbImage)
        }
    }

}