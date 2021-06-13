# news_app_clean

A demo News Application follow Clean Architecture

* :domain
* :data
* :presentation (use MVVM)

Features:

* load list newsfeed and detail new
* support cache news feed
* support dark theme follow system

Lib:

* Android jetpack
* Kotlin coroutines
* Glide
* DI use Hilt

# cache resource

* Use Single source of truth handle cache data.
Implement with BoundDataNetwork.class in :data module
* Use Glide to cache image

# Handle case news feed complicated

* Show news feed by a RecyclerView and multi type ViewHolder.
Ex: VideoViewHolder, ImageViewHolder, SliderViewHolder....

-> Use DiffCallBack (diff in background thread) to handle case item not same
-> If case itemNotSameContent -> Cache all current ViewHolder -> invoke rebind viewHolder for corresponding change data
