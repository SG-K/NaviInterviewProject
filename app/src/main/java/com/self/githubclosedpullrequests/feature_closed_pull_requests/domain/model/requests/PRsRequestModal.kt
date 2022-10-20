package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.requests

data class PRsRequestModal(
    val userName : String,
    val repository : String,
    val pullRequestState : String,
    val page : Int,
    val perPage : Int
)
