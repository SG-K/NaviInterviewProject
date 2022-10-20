package com.self.githubclosedpullrequests.feature_closed_pull_requests.data.repository

import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.repository.GitHubRepository
import com.self.githubclosedpullrequests.feature_closed_pull_requests.data.data_source.GitHubAPIService
import com.self.githubclosedpullrequests.feature_closed_pull_requests.data.mappers.CollosedPullRequestsMapper
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.PullRequestsResponse
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui.PullRequestUIModel
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.requests.PRsRequestModal
import java.lang.Exception

class GitHubRepositoryImpl(
    private val gitHubAPIService: GitHubAPIService
) : GitHubRepository {

    override suspend fun getClosedPullRequestList(
        prsRequestModal : PRsRequestModal
    ): Result<List<PullRequestUIModel>> {
        return try {
            Result.success(
                CollosedPullRequestsMapper.mapEntity(
                    gitHubAPIService.getClosedPullRequestList(
                        owner = prsRequestModal.userName,
                        repository = prsRequestModal.repository,
                        state = prsRequestModal.pullRequestState,
                        page = prsRequestModal.page,
                        perPage = prsRequestModal.perPage
                    )
                )
            )
        } catch (e:Exception) {
            // In realtime projects we can improve custom error handling with appropriate messages
            Result.failure(e)
        }
    }

}