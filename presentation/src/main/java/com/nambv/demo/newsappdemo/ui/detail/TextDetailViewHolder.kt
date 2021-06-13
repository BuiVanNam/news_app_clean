package com.nambv.demo.newsappdemo.ui.detail

import com.nambv.demo.domain.model.base.SectionTextModel
import com.nambv.demo.newsappdemo.databinding.ItemTextNewBinding

/**
 * Created by nambv on 6/13/2021
 */
class TextDetailViewHolder(private val binding: ItemTextNewBinding) :
    BaseDetailNewInfoViewHolder<SectionTextModel>(binding) {

    override fun bindItem(content: SectionTextModel) {
        content.run {
            binding.contentTextNew.text = text
        }
    }

}