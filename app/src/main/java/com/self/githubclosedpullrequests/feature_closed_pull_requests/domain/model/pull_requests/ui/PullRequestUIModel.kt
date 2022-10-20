package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui

data class PullRequestUIModel(
    val title : String,
    val userName : String,
    val userImage : String,
    val createdOn : String,
    val closedOn : String
)
