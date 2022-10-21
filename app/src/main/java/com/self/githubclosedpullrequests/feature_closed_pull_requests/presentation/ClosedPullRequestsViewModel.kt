package com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.self.githubclosedpullrequests.feature_closed_pull_requests.util.pagination.DefaultPaginator
import com.self.githubclosedpullrequests.core.utils.GitHubConstants
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.requests.PRsRequestModal
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.use_case.GetClosedPullRequestsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClosedPullRequestsListViewModel @Inject constructor(
    private val getClosedPullRequestsUseCase: GetClosedPullRequestsUseCase,
) : ViewModel() {

    var state by mutableStateOf(ClosedPullRequestsListState())


    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(
                isLoading = it,
                error = if (it) { null } else { state.error }
            )
        },
        onRequest = { nextPage ->
            getClosedPullRequestsUseCase.invoke(
                prsRequestModal = PRsRequestModal(
                    userName = GitHubConstants.GITHUB_USER,
                    repository = GitHubConstants.GITHUB_REPO,
                    pullRequestState = GitHubConstants.PULL_REQUEST_STATE,
                    page = nextPage,
                    perPage = GitHubConstants.PER_PAGE_LIMIT
                )
            )
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                closedPullRequestsList = state.closedPullRequestsList + items,
                page = newKey,
                endReached = items.isEmpty()
            )
        }
    )

    init {
        loadNextItens()
    }

    fun loadNextItens(){
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

}