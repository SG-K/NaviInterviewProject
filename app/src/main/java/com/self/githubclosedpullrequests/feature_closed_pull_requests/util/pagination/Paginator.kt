package com.self.githubclosedpullrequests.feature_closed_pull_requests.util.pagination

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}