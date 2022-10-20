package com.self.githubclosedpullrequests.feature_closed_pull_requests.data.data_source

import com.self.githubclosedpullrequests.core.utils.GitHubConstants
import com.self.githubclosedpullrequests.core.utils.QueryParamConstants
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.PullRequestsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubAPIService {

    @GET(GitHubConstants.PULL_REQUESTS_END_POINT)
    suspend fun getClosedPullRequestList(
        @Path(QueryParamConstants.OWNER) owner : String,
        @Path(QueryParamConstants.REPOSITORY) repository : String,
        @Query(QueryParamConstants.STATE) state : String,
        @Query(QueryParamConstants.PAGE) page : Int,
        @Query(QueryParamConstants.PERPAGE) perPage : Int
    ) : List<PullRequestsResponse>

}