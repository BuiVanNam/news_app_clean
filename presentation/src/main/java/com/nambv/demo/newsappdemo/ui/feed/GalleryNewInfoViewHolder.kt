package com.nambv.demo.newsappdemo.ui.feed

import android.annotation.SuppressLint
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.newsappdemo.databinding.ItemNewGalleryBinding
import com.nambv.demo.newsappdemo.utils.DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
import com.nambv.demo.newsappdemo.utils.DEFAULT_SIZE_WIDTH_LOAD_IMAGE

/**
 * Created by nambv on 6/13/2021
 */
class GalleryNewInfoViewHolder(private val binding: ItemNewGalleryBinding) :
    BaseNewInfoViewHolder(binding) {


    @SuppressLint("SetTextI18n")
    override fun bindItem(newInfo: NewInfoModel) {
        newInfo.run {

            binding.titleNew.text = title
            binding.publisherNew.text = publisherNewModel?.name + " . " + publishedDate

            var image1: String? = null
            var image2: String? = null
            var image3: String? = null

            try {
                image1 = listImage?.get(0)
                image2 = listImage?.get(1)
                image3 = listImage?.get(2)
            } catch (e: Exception) {

            }

            requestManager
                .load(image1)
                .placeholder(placeHolderDrawable)
                .error(placeHolderDrawable)
                .override(DEFAULT_SIZE_WIDTH_LOAD_IMAGE, DEFAULT_SIZE_HEIGHT_LOAD_IMAGE)
                .centerCrop()
                .into(binding.thumbImage01)

            requestManager
                .load(image2)
                .placeholder(placeHolderDrawable)
                .error(placeHolderDrawable)
                .override(DEFAULT_SIZE_WIDTH_LOAD_IMAGE, DEFAULT_SIZE_HEIGHT_LOAD_IMAGE)
                .centerCrop()
                .into(binding.thumbImage02)

            requestManager
                .load(image3)
                .placeholder(placeHolderDrawable)
                .error(placeHolderDrawable)
                .override(DEFAULT_SIZE_WIDTH_LOAD_IMAGE, DEFAULT_SIZE_HEIGHT_LOAD_IMAGE)
                .centerCrop()
                .into(binding.thumbImage03)
        }
    }

}