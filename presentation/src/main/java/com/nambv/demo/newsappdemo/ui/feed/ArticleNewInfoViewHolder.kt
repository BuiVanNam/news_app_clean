package com.nambv.demo.newsappdemo.ui.feed

import android.annotation.SuppressLint
import android.graphics.Outline
import android.graphics.Rect
import android.view.View
import android.view.ViewOutlineProvider
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.newsappdemo.R
import com.nambv.demo.newsappdemo.databinding.ItemNewArticleBinding
import com.nambv.demo.newsappdemo.utils.DEFAULT_SIZE_HEIGHT_LOAD_IMAGE
import com.nambv.demo.newsappdemo.utils.DEFAULT_SIZE_WIDTH_LOAD_IMAGE

/**
 * Created by nambv on 6/13/2021
 */
class ArticleNewInfoViewHolder(private val binding: ItemNewArticleBinding) :
    BaseNewInfoViewHolder(binding) {

    init {
        binding.thumbImage.apply {
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(
                        Rect(0, 0, view.width, view.height),
                        resources.getDimension(R.dimen.corner_image_thumb)
                    )
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun bindItem(newInfo: NewInfoModel) {
        newInfo.run {
            binding.titleNew.text = title
            binding.desNew.text = description
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