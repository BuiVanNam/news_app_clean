package com.nambv.demo.newsappdemo.ui.detail

import android.graphics.drawable.ColorDrawable
import androidx.viewbinding.ViewBinding
import com.nambv.demo.domain.model.base.BaseContentSessionDetail
import com.nambv.demo.newsappdemo.R
import com.nambv.demo.newsappdemo.ui.common.BaseViewHolder
import com.nambv.demo.newsappdemo.utils.GlideApp


abstract class BaseDetailNewInfoViewHolder<T : BaseContentSessionDetail>(binding: ViewBinding) :
    BaseViewHolder(binding) {

    protected val requestManager = GlideApp.with(itemView.context)
    protected val placeHolderDrawable =
        ColorDrawable(itemView.context.resources.getColor(R.color.colorPlaceHolder))

    fun invokeContentToBind(content: BaseContentSessionDetail) {
        bindItem(content = content as T)
    }

    abstract fun bindItem(content: T)

}