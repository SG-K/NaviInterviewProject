package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests

import com.google.gson.annotations.SerializedName


data class PullRequestsResponse (

  @SerializedName("url"                 ) var url                : String?           = null,
  @SerializedName("id"                  ) var id                 : Int?              = null,
  @SerializedName("node_id"             ) var nodeId             : String?           = null,
  @SerializedName("html_url"            ) var htmlUrl            : String?           = null,
  @SerializedName("diff_url"            ) var diffUrl            : String?           = null,
  @SerializedName("patch_url"           ) var patchUrl           : String?           = null,
  @SerializedName("issue_url"           ) var issueUrl           : String?           = null,
  @SerializedName("number"              ) var number             : Int?              = null,
  @SerializedName("state"               ) var state              : String?           = null,
  @SerializedName("locked"              ) var locked             : Boolean?          = null,
  @SerializedName("title"               ) var title              : String?           = null,
  @SerializedName("user"                ) var user               : User?             = null,
  @SerializedName("body"                ) var body               : String?           = null,
  @SerializedName("created_at"          ) var createdAt          : String?           = null,
  @SerializedName("updated_at"          ) var updatedAt          : String?           = null,
  @SerializedName("closed_at"           ) var closedAt           : String?           = null,
  @SerializedName("merged_at"           ) var mergedAt           : String?           = null,
  @SerializedName("merge_commit_sha"    ) var mergeCommitSha     : String?           = null,
  @SerializedName("assignee"            ) var assignee           : String?           = null,
  @SerializedName("assignees"           ) var assignees          : ArrayList<String>? = null,
  @SerializedName("requested_reviewers" ) var requestedReviewers : ArrayList<String>? = null,
  @SerializedName("requested_teams"     ) var requestedTeams     : ArrayList<String>? = null,
  @SerializedName("labels"              ) var labels             : ArrayList<String>? = null,
  @SerializedName("milestone"           ) var milestone          : String?           = null,
  @SerializedName("draft"               ) var draft              : Boolean?          = null,
  @SerializedName("commits_url"         ) var commitsUrl         : String?           = null,
  @SerializedName("review_comments_url" ) var reviewCommentsUrl  : String?           = null,
  @SerializedName("review_comment_url"  ) var reviewCommentUrl   : String?           = null,
  @SerializedName("comments_url"        ) var commentsUrl        : String?           = null,
  @SerializedName("statuses_url"        ) var statusesUrl        : String?           = null,
  @SerializedName("head"                ) var head               : Head?             = null,
  @SerializedName("base"                ) var base               : Base?             = null,
  @SerializedName("_links"              ) var Links              : Links?            = null,
  @SerializedName("author_association"  ) var authorAssociation  : String?           = null,
  @SerializedName("auto_merge"          ) var autoMerge          : String?           = null,
  @SerializedName("active_lock_reason"  ) var activeLockReason   : String?           = null

)