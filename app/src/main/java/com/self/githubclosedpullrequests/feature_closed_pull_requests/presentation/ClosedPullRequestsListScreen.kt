package com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.self.githubclosedpullrequests.R
import com.self.githubclosedpullrequests.core.utils.TestTags
import com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation.components.ClosedPullRequestsListTopBar
import com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation.components.ClosedPullRequestListItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ClosedPullRequestsListScreen(
    navController: NavController, // Used for navigations in real-time projects
    viewModel: ClosedPullRequestsListViewModel = hiltViewModel()
){
    val state = viewModel.state
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            ClosedPullRequestsListTopBar()
        },
        scaffoldState = scaffoldState
    ) {

        // Initial Loading
        AnimatedVisibility(
            visible = state.isLoading && state.page == 1
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .testTag(TestTags.Loading)
            ){
                CircularProgressIndicator()
            }
        }

        // Empty and Error UI Handling
        AnimatedVisibility(
            visible = state.closedPullRequestsList.isEmpty() &&
                    !state.isLoading
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = if (state.error.isNullOrEmpty()) {
                                stringResource(id = R.string.empty_list_msg)
                           } else {
                               state.error
                           },
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp),
                )

                AnimatedVisibility(visible = !state.error.isNullOrEmpty()) {
                    Button(onClick = {
                        viewModel.loadNextItens()
                    }) {
                        Text(
                            text = stringResource(id = R.string.retry_label)
                        )
                    }
                }

            }
        }

        // List of pull requests
        AnimatedVisibility(
            visible = state.closedPullRequestsList.isNotEmpty()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag(TestTags.LazyColumnPullRequests)
            ) {

                itemsIndexed(state.closedPullRequestsList) { index, item ->

                    if (
                        index >= state.closedPullRequestsList.size - 1 &&
                        !state.endReached &&
                        !state.isLoading &&
                        state.error.isNullOrEmpty()
                    ){
                        viewModel.loadNextItens()
                    }

                    ClosedPullRequestListItem(
                        pullRequest = item,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                // Loading handling while pagination
                item {
                    if (
                        state.isLoading &&
                        state.page != 1
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                // Error Handling while pagination
                item {
                    if (
                        !state.isLoading &&
                        state.page != 1 &&
                        state.error != null
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = state.error,
                                textAlign = TextAlign.Center,
                            )
                            Button(onClick = {
                                viewModel.loadNextItens()
                            }) {
                                Text(
                                    text = stringResource(id = R.string.retry_label)
                                )
                            }
                        }
                    }
                }
            }
        }

    }

}