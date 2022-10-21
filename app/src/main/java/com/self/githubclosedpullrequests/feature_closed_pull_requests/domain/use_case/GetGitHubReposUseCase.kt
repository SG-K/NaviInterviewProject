package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.use_case

import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui.PullRequestUIModel
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.requests.PRsRequestModal
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.repository.GitHubClosedPullRequests

class GetClosedPullRequestsUseCase (
    private val repository: GitHubClosedPullRequests
) {

    suspend operator fun invoke(prsRequestModal : PRsRequestModal) : Result<List<PullRequestUIModel>> {
        return repository.getClosedPullRequestList(prsRequestModal)
    }
}