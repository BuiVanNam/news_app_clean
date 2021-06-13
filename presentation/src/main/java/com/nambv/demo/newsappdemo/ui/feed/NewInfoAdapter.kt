package com.nambv.demo.newsappdemo.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nambv.demo.domain.model.feed.NewInfoModel
import com.nambv.demo.domain.model.feed.TypeNew
import com.nambv.demo.newsappdemo.databinding.ItemNewArticleBinding
import com.nambv.demo.newsappdemo.databinding.ItemNewGalleryBinding
import com.nambv.demo.newsappdemo.databinding.ItemNewVideoBinding
import com.nambv.demo.newsappdemo.ui.common.BaseAdapter
import com.nambv.demo.newsappdemo.ui.common.BaseViewHolder


class NewInfoAdapter : BaseAdapter<NewInfoModel>(DiffNewInfoData()) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).contentType) {
            TypeNew.VIDEO -> TypeNew.VIDEO.ordinal
            TypeNew.GALLERY -> TypeNew.GALLERY.ordinal
            else -> TypeNew.ARTICLE.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            TypeNew.VIDEO.ordinal -> return VideoNewInfoViewHolder(
                ItemNewVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            TypeNew.GALLERY.ordinal -> return GalleryNewInfoViewHolder(
                ItemNewGalleryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> return ArticleNewInfoViewHolder(
                ItemNewArticleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is BaseNewInfoViewHolder) {
            holder.bindItem(getItem(position))
        }
    }

}