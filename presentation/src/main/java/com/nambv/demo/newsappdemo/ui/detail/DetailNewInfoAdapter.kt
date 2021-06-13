package com.nambv.demo.newsappdemo.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nambv.demo.domain.model.base.BaseContentSessionDetail
import com.nambv.demo.domain.model.base.SectionImageModel
import com.nambv.demo.domain.model.base.SectionTextModel
import com.nambv.demo.domain.model.base.SectionVideoModel
import com.nambv.demo.newsappdemo.databinding.ItemHeaderNewBinding
import com.nambv.demo.newsappdemo.databinding.ItemImageNewBinding
import com.nambv.demo.newsappdemo.databinding.ItemTextNewBinding
import com.nambv.demo.newsappdemo.databinding.ItemVideoNewBinding
import com.nambv.demo.newsappdemo.ui.common.BaseAdapter
import com.nambv.demo.newsappdemo.ui.common.BaseViewHolder


private const val ITEM_HEADER = 0
private const val ITEM_TEXT = 1
private const val ITEM_IMAGE = 2
private const val ITEM_VIDEO = 3

class DetailNewInfoAdapter : BaseAdapter<BaseContentSessionDetail>(DiffDetailNewInfoData()) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is SectionVideoModel -> ITEM_VIDEO
            is SectionImageModel -> ITEM_IMAGE
            is SectionTextModel -> ITEM_TEXT
            else -> ITEM_HEADER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            ITEM_VIDEO -> return VideoDetailViewHolder(
                ItemVideoNewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            ITEM_IMAGE -> return ImageDetailViewHolder(
                ItemImageNewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            ITEM_TEXT -> return TextDetailViewHolder(
                ItemTextNewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> return HeaderDetailViewHolder(
                ItemHeaderNewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is BaseDetailNewInfoViewHolder<*>) {
            holder.invokeContentToBind(getItem(position))
        }
    }

}