package com.example.submissionbfaa

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var avatar: Int? = 0,
    var username: String? = "",
    var name: String? = "",
    var location: String? = "",
    var company: String? = "",
    var repository: String? = "",
    var followers: String? = "",
    var following: String? = ""
) : Parcelable