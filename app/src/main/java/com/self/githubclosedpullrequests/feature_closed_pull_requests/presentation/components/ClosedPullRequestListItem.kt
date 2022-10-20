package com.self.githubclosedpullrequests.feature_closed_pull_requests.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.self.githubclosedpullrequests.R
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests.ui.PullRequestUIModel

@Composable
fun ClosedPullRequestListItem(
    pullRequest: PullRequestUIModel,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current

    Card(
        elevation = 5.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
    ) {

        ConstraintLayout(
            modifier = Modifier
                .padding(16.dp)
        ) {

            val (title, subtitle, image, createdOn, closedOn) = createRefs()

            Box (
                modifier = Modifier
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .padding(top = 4.dp)
            ){
                Box(
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.4f))
                )
                AsyncImage(
                    model = pullRequest.userImage,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                        .clip(CircleShape)
                )
            }

            Text(
                text = pullRequest.userName,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(title) {
                        start.linkTo(image.end)
                        top.linkTo(parent.top)
                    }
                    .padding(
                        start = 14.dp, end = 10.dp
                    )
            )

            Text(
                text = pullRequest.title,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(subtitle) {
                        start.linkTo(image.end)
                        top.linkTo(title.bottom)
                    }
                    .padding(
                        start = 14.dp, end = 10.dp
                    )
            )

            Text(
                text = stringResource(id = R.string.created_on) + pullRequest.createdOn,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(createdOn) {
                        start.linkTo(image.end)
                        top.linkTo(subtitle.bottom)
                    }
                    .padding(
                        top = 10.dp, start = 14.dp, end = 10.dp
                    )
            )

            Text(
                text = stringResource(id = R.string.closed_on) + pullRequest.closedOn,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(closedOn) {
                        start.linkTo(image.end)
                        top.linkTo(createdOn.bottom)
                    }
                    .padding(
                        start = 14.dp, end = 10.dp
                    )
            )

        }

    }

}

