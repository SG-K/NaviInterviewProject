package com.self.githubclosedpullrequests.core.utils

object GitHubConstants {

    const val BASE_URL = "https://api.github.com/repos/"

    const val PULL_REQUESTS_END_POINT = "{${QueryParamConstants.OWNER}}/{${QueryParamConstants.REPOSITORY}}/pulls"

    // Hardcoded Data
    const val GITHUB_USER = "stfalcon-studio"
    const val GITHUB_REPO = "StfalconImageViewer"
//    const val GITHUB_USER = "SG-K"
    //    const val GITHUB_REPO = "RecyclerviewWithBenefits"
    const val PULL_REQUEST_STATE = "closed"
    const val PER_PAGE_LIMIT = 3
}