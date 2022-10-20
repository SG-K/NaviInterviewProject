package com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.self.githubclosedpullrequests.core.ideling_resources.ComposeOkHttp3IdlingResource
import com.self.githubclosedpullrequests.core.utils.GitHubConstants
import com.self.githubclosedpullrequests.core.utils.TestTags
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ClosedPullRequestsListScreenKtTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule(MainActivity::class.java)

    @Inject
    lateinit var composeOkHttp3IdlingResource: ComposeOkHttp3IdlingResource

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    /**
     * Integration test to test API calls with composeOkHttp3IdlingResource.
     * Internally using espresso idleresource registering
     *
     * Test to make sure we're getting data from github service and displayed
     * on the screen
     *
     * Note: Strings we used to identify the nodes are specific to the github account
     * details hardcoded in the project. Here we're not using mock we server instead
     * we're running the integration test with real-time API calls.
     */
    @Test
    fun getList_checkExpectedDataPresence(){
        composeRule.onNodeWithTag(TestTags.Loading).assertExists()
        composeRule.onNodeWithTag(TestTags.Loading).assertIsDisplayed()
        composeRule.registerIdlingResource(composeOkHttp3IdlingResource)
        composeRule.onNodeWithText("Add function withBackgroundAlpha").assertExists()
        composeRule.onNodeWithText("Add function withBackgroundAlpha").assertIsDisplayed()
    }

    /**
     * Test to make sure pagination is working as expected.
     *
     * Note: Strings we used to identify the nodes are specific to the github account
     * details hardcoded in the project. Here we're not using mock we server instead
     * we're running the integration test with real-time API calls.
     */
    @Test
    fun getListWithPagination_checkPaginatedDataIsDisplayed(){
        composeRule.onNodeWithTag(TestTags.Loading).assertExists()
        composeRule.onNodeWithTag(TestTags.Loading).assertIsDisplayed()
        composeRule.registerIdlingResource(composeOkHttp3IdlingResource)
        composeRule.onNodeWithText("Add function withBackgroundAlpha").assertExists()
        composeRule.onNodeWithText("Add function withBackgroundAlpha").assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.LazyColumnPullRequests).assertExists()
        composeRule.onNodeWithTag(TestTags.LazyColumnPullRequests).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.LazyColumnPullRequests).performScrollToIndex(GitHubConstants.PER_PAGE_LIMIT)
        composeRule.onNodeWithText("fix: Check lateinit status before accessing animator").assertExists()
        composeRule.onNodeWithText("fix: Check lateinit status before accessing animator").assertIsDisplayed()
    }

    @After
    fun tearDown() {
        composeRule.unregisterIdlingResource(composeOkHttp3IdlingResource)
    }
}