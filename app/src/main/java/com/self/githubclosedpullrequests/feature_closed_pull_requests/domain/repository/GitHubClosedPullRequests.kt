package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.repository

import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.PullRequestsResponse
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui.PullRequestUIModel
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.requests.PRsRequestModal

interface GitHubClosedPullRequests {
    
    suspend fun getClosedPullRequestList(prsRequestModal : PRsRequestModal) : Result<List<PullRequestUIModel>>

}