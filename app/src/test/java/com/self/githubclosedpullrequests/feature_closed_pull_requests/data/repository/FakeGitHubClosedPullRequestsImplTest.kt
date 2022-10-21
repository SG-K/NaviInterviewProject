package com.self.githubclosedpullrequests.feature_closed_pull_requests.data.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.self.githubclosedpullrequests.feature_closed_pull_requests.data.mappers.CollosedPullRequestsMapper
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.PullRequestsResponse
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui.PullRequestUIModel
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.requests.PRsRequestModal
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.repository.GitHubClosedPullRequests
import java.io.InputStreamReader
import java.lang.Exception

data class MockResposen(
    val list : List<PullRequestsResponse>?
)

class FakeGitHubClosedPullRequestsImplTest : GitHubClosedPullRequests {

    fun getJsonContent(fileName: String): String {
        return InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream(fileName)).use { it.readText() }
    }

    override suspend fun getClosedPullRequestList(
        prsRequestModal: PRsRequestModal
    ): Result<List<PullRequestUIModel>> {
        val jsonString =  getJsonContent("closed_pull_request_list_response.json")
        val arrayTutorialType = object : TypeToken<List<PullRequestsResponse>>() {}.type
        val list: List<PullRequestsResponse>? = Gson().fromJson(jsonString, arrayTutorialType)
        return list?.let {
            return Result.success(CollosedPullRequestsMapper.mapEntity(list))
        } ?: Result.failure(Exception("File Not Found"))
    }

}