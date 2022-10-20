package com.self.githubclosedpullrequests.feature_closed_pull_requests.util.extensions

fun String?.valid() : Boolean{
    return this != null && this.isNotEmpty() && !this.equals("null",ignoreCase = true)
}