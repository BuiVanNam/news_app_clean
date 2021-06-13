package com.nambv.demo.newsappdemo.ui.detail

import android.annotation.SuppressLint
import com.nambv.demo.newsappdemo.databinding.ItemHeaderNewBinding
import com.nambv.demo.newsappdemo.model.SectionHeaderDetailModel

/**
 * Created by nambv on 6/13/2021
 */
class HeaderDetailViewHolder(private val binding: ItemHeaderNewBinding) :
    BaseDetailNewInfoViewHolder<SectionHeaderDetailModel>(binding) {

    @SuppressLint("SetTextI18n")
    override fun bindItem(content: SectionHeaderDetailModel) {
        content.run {
            binding.titleNew.text = title
            binding.desNew.text = description
            binding.publisherNew.text = publisher?.name + " . " + pubDate
        }
    }

}