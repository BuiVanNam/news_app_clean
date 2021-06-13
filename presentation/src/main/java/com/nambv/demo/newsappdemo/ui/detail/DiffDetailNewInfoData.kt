package com.nambv.demo.newsappdemo.ui.detail

import androidx.recyclerview.widget.DiffUtil
import com.nambv.demo.domain.model.base.BaseContentSessionDetail

class DiffDetailNewInfoData : DiffUtil.ItemCallback<BaseContentSessionDetail>() {

    override fun areItemsTheSame(
        oldItem: BaseContentSessionDetail,
        newItem: BaseContentSessionDetail
    ): Boolean {
        return false
    }

    override fun areContentsTheSame(
        oldItem: BaseContentSessionDetail,
        newItem: BaseContentSessionDetail
    ): Boolean {
        return false
    }

}