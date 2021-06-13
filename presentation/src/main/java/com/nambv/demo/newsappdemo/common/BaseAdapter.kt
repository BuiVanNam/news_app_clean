package com.nambv.demo.newsappdemo.common

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseViewHolder>(diffCallback)