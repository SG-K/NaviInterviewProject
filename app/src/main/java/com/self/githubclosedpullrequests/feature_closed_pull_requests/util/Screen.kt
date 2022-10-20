package com.self.githubclosedpullrequests.feature_closed_pull_requests.util

sealed class Screen(val route : String) {

    object ClosedPullRequestsScreen: Screen("closed_pull_requests_list_screen")

}