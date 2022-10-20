package com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.self.githubclosedpullrequests.feature_closed_pull_requests.util.Screen
import com.self.githubclosedpullrequests.ui.theme.GitHubClosedPullRequestsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubClosedPullRequestsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ClosedPullRequestsScreen.route
                    ) {
                        composable(route = Screen.ClosedPullRequestsScreen.route) {
                            ClosedPullRequestsListScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
