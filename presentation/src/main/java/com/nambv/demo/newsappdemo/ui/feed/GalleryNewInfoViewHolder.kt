package com.nambv.demo.newsappdemo.ui.feed

import android.annotation.SuppressLint
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.newsappdemo.databinding.ItemNewGalleryBinding
import com.nambv.demo.newsappdemo.utils.DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
import com.nambv.demo.newsappdemo.utils.DEFAULT_SIZE_WIDTH_LOAD_IMAGE
import com.nambv.demo.newsappdemo.utils.loadImage

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

            binding.thumbImage01.loadImage(
                requestManager,
                placeHolderDrawable,
                placeHolderDrawable,
                image1,
                DEFAULT_SIZE_WIDTH_LOAD_IMAGE,
                DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
            )

            binding.thumbImage02.loadImage(
                requestManager,
                placeHolderDrawable,
                placeHolderDrawable,
                image2,
                DEFAULT_SIZE_WIDTH_LOAD_IMAGE,
                DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
            )

            binding.thumbImage03.loadImage(
                requestManager,
                placeHolderDrawable,
                placeHolderDrawable,
                image3,
                DEFAULT_SIZE_WIDTH_LOAD_IMAGE,
                DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
            )

        }
    }

}