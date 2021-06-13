package com.nambv.demo.newsappdemo.ui.feed

import android.graphics.drawable.ColorDrawable
import androidx.viewbinding.ViewBinding
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.newsappdemo.R
import com.nambv.demo.newsappdemo.ui.common.BaseViewHolder
import com.nambv.demo.newsappdemo.utils.GlideApp


abstract class BaseNewInfoViewHolder(binding: ViewBinding) :
    BaseViewHolder(binding) {

    protected val requestManager = GlideApp.with(itemView.context)
    protected val placeHolderDrawable =
        ColorDrawable(itemView.context.resources.getColor(R.color.colorPlaceHolder))

    init {
        itemView.setOnClickListener {

        }
    }

    abstract fun bindItem(newInfo: NewInfoModel)

}