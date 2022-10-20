package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests

import com.google.gson.annotations.SerializedName


data class ReviewComments (

  @SerializedName("href" ) var href : String? = null

)