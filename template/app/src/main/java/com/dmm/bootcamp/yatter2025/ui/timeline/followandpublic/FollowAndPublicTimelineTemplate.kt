package com.dmm.bootcamp.yatter2025.ui.timeline.followandpublic

import android.text.format.Time
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dmm.bootcamp.yatter2025.ui.theme.Yatter2025Theme
import com.dmm.bootcamp.yatter2025.ui.timeline.TimelineBlock
import com.dmm.bootcamp.yatter2025.ui.timeline.bindingmodel.YweetBindingModel

@Composable
fun FollowAndPublicTimelineTemplate(
    followYweetList: List<YweetBindingModel>,
    publicYweetList: List<YweetBindingModel>,
    selectedTab: TimelineTab,
    isLoading: Boolean,
    isRefreshing: Boolean,
    onClickTab: (TimelineTab) -> Unit,
    onRefresh: () -> Unit,
    onClickPost: () -> Unit,
) {
    Scaffold { paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues)
        ) {
            TabRow(
                selectedTabIndex = selectedTab.ordinal,
            ) {
                TimelineTab.entries.forEach { tab ->
                    Tab(
                        selected = tab == selectedTab,
                        text = { Text(tab.displayName) },
                        onClick = { onClickTab(tab) },
                    )
                }
            }
        }
//        TimelineBlock(
//            yweetList = followYweetList,
//            isLoading = isLoading,
//            isRefreshing = isRefreshing,
//            onRefresh = onRefresh,
//            onClickPost = onClickPost,
//            paddingValues = paddingValues
//        )
    }
}

@Preview
@Composable
private fun FollowAndPublicTimelineTemplatePreview() {
    Yatter2025Theme {
        Surface {
            FollowAndPublicTimelineTemplate(
                followYweetList =  listOf(
                    YweetBindingModel(
                        id = "id1",
                        displayName = "display name1",
                        username = "username1",
                        avatar = null,
                        content = "preview content1",
                        attachmentImageList = listOf()
                    ),
                    YweetBindingModel(
                        id = "id2",
                        displayName = "display name2",
                        username = "username2",
                        avatar = null,
                        content = "preview content2",
                        attachmentImageList = listOf()
                    ),
                ),
                publicYweetList = listOf(
                    YweetBindingModel(
                        id = "id1",
                        displayName = "display name1",
                        username = "username1",
                        avatar = null,
                        content = "preview content1",
                        attachmentImageList = listOf()
                    ),
                    YweetBindingModel(
                        id = "id2",
                        displayName = "display name2",
                        username = "username2",
                        avatar = null,
                        content = "preview content2",
                        attachmentImageList = listOf()
                    ),
                ),
                selectedTab = TimelineTab.Public,
                isLoading = false,
                isRefreshing = false,
                onClickTab = {},
                onRefresh = {},
                onClickPost = {},
            )
        }
    }
}