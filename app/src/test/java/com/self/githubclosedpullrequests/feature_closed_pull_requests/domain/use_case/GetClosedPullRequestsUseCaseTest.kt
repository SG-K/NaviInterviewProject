package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.use_case

import com.google.common.truth.Truth
import com.self.githubclosedpullrequests.core.utils.GitHubConstants
import com.self.githubclosedpullrequests.feature_closed_pull_requests.data.repository.FakeGitHubClosedPullRequestsImplTest
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui.PullRequestUIModel
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.requests.PRsRequestModal
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.repository.GitHubClosedPullRequests
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetClosedPullRequestsUseCaseTest{

    private lateinit var getClosedPullRequestsUseCase: GetClosedPullRequestsUseCase
    private lateinit var fakeGitHubRepositoryImplTest: GitHubClosedPullRequests

    @Before
    fun setUp(){

        fakeGitHubRepositoryImplTest = FakeGitHubClosedPullRequestsImplTest()
        getClosedPullRequestsUseCase = GetClosedPullRequestsUseCase(repository = fakeGitHubRepositoryImplTest)

    }

    @Test
    fun `Get Closed PullRequests`(){
        runBlocking {
            val result : Result<List<PullRequestUIModel>> = getClosedPullRequestsUseCase.invoke(
                prsRequestModal = PRsRequestModal(
                    userName = GitHubConstants.GITHUB_USER,
                    repository = GitHubConstants.GITHUB_REPO,
                    pullRequestState = GitHubConstants.PULL_REQUEST_STATE,
                    page = 1,
                    perPage = GitHubConstants.PER_PAGE_LIMIT
                )
            )

            val list : List<PullRequestUIModel> = result.getOrElse {
                emptyList()
            }

            Truth.assertThat(list.size).isEqualTo(8)
        }
    }

}