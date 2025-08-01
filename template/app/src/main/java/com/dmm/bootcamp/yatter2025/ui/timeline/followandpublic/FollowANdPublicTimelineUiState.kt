package com.dmm.bootcamp.yatter2025.ui.timeline.followandpublic

import com.dmm.bootcamp.yatter2025.ui.timeline.bindingmodel.YweetBindingModel
import com.dmm.bootcamp.yatter2025.ui.timeline.publictl.PublicTimelineUiState

data class FollowANdPublicTimelineUiState (
    val followYweetList: List<YweetBindingModel>,
    val publicYweetList: List<YweetBindingModel>,
    val selectedTab: TimelineTab,
    val isLoading: Boolean,
    val isRefreshing: Boolean,
    ) {
        companion object {
            fun empty(): FollowANdPublicTimelineUiState = FollowANdPublicTimelineUiState(
                followYweetList = emptyList(),
                publicYweetList = emptyList(),
                selectedTab = TimelineTab.Follow,
                isLoading = false,
                isRefreshing = false,
            )
        }
    }