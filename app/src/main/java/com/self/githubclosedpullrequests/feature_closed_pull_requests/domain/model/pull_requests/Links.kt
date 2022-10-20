package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests

import com.google.gson.annotations.SerializedName


data class Links (

  @SerializedName("self"            ) var self           : Self?           = null,
  @SerializedName("html"            ) var html           : Html?           = null,
  @SerializedName("issue"           ) var issue          : Issue?          = null,
  @SerializedName("comments"        ) var comments       : Comments?       = null,
  @SerializedName("review_comments" ) var reviewComments : ReviewComments? = null,
  @SerializedName("review_comment"  ) var reviewComment  : ReviewComment?  = null,
  @SerializedName("commits"         ) var commits        : Commits?        = null,
  @SerializedName("statuses"        ) var statuses       : Statuses?       = null

)