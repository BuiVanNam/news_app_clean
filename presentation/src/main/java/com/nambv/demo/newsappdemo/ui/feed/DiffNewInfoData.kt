package com.nambv.demo.newsappdemo.ui.feed

import androidx.recyclerview.widget.DiffUtil
import com.nambv.demo.domain.model.feed.NewInfoModel

class DiffNewInfoData : DiffUtil.ItemCallback<NewInfoModel>() {

    override fun areItemsTheSame(oldItem: NewInfoModel, newItem: NewInfoModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NewInfoModel, newItem: NewInfoModel): Boolean {
        return oldItem.sameContent(newItem)
    }

}