package com.self.githubclosedpullrequests.feature_closed_pull_requests.util

import com.google.common.truth.Truth
import org.junit.Test

class TimerExtensionsKtTest{
    val actualDate : String = "2019-11-24T20:45:08Z"
    val expectedDate : String = "25 November 2019, 02:15 AM"

    @Test
    fun dateFormatTest(){
        val result = actualDate.dateFormat()
        Truth.assertThat(result).isEqualTo(expectedDate)
    }

}