package com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.self.githubclosedpullrequests.R

@Composable
@Preview
fun ClosedPullRequestsListTopBar(
    modifier: Modifier = Modifier
){

    ConstraintLayout (
        modifier = modifier
            .fillMaxWidth(),
    ){
        val (title) = createRefs()

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 20.sp,
            color = MaterialTheme.colors.primaryVariant,
            modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(parent.start)
                }
                .padding(16.dp),
            fontWeight = FontWeight(600)
        )

    }
}