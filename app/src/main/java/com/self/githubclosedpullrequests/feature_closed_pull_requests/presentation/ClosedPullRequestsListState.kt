package com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation

import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.PullRequestsResponse
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui.PullRequestUIModel

data class ClosedPullRequestsListState(
    val isLoading : Boolean = false,
    val closedPullRequestsList : List<PullRequestUIModel> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 1
)
