package com.self.githubclosedpullrequests.feature_closed_pull_requests.data.mappers

import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.PullRequestsResponse
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui.PullRequestUIModel
import com.self.githubclosedpullrequests.feature_closed_pull_requests.util.dateFormat
import com.self.githubclosedpullrequests.feature_closed_pull_requests.util.extensions.valid

object CollosedPullRequestsMapper  {

    fun mapEntity(model: List<PullRequestsResponse>): List<PullRequestUIModel> {
        val resultList : ArrayList<PullRequestUIModel> = ArrayList()

        model.filter {
            it.title.valid() && it.user?.login.valid()
                    && it.user?.avatarUrl.valid() && it.createdAt.valid()
                    && it.closedAt.valid()
        }.map {
            resultList.add(
                PullRequestUIModel(
                    title = it.title?:"",
                    userName = it.user?.login?:"",
                    userImage = it.user?.avatarUrl?:"",
                    createdOn = " ${it.createdAt?:"".dateFormat()}",
                    closedOn = " ${it.closedAt?:"".dateFormat()}"
                )
            )
        }

        return resultList

    }

}