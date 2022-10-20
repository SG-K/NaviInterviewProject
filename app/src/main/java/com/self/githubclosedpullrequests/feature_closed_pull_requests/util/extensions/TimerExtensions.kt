package com.self.githubclosedpullrequests.feature_closed_pull_requests.util

import com.self.githubclosedpullrequests.core.utils.print
import java.text.SimpleDateFormat
import java.util.*


fun String.dateFormat(): String {
    return try {
        if (this.isEmpty()){
            return ""
        }
        val inputDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val outputDateFormat = SimpleDateFormat("dd MMMM yyyy, hh:mm aa")
        inputDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        outputDateFormat.timeZone = TimeZone.getDefault()
        val parsedDate = inputDateFormat.parse(this)
        outputDateFormat.format(parsedDate)
    } catch (e: Exception) {
        "TimerException - ${e.message}".print()
        ""
    }
}