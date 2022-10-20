package com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.model.pull_requests

import com.google.gson.annotations.SerializedName


data class Head (

  @SerializedName("label" ) var label : String? = null,
  @SerializedName("ref"   ) var ref   : String? = null,
  @SerializedName("sha"   ) var sha   : String? = null,
  @SerializedName("user"  ) var user  : User?   = null,
  @SerializedName("repo"  ) var repo  : Repo?   = null

)