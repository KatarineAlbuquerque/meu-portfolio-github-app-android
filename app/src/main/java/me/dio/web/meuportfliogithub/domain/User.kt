package me.dio.web.meuportfliogithub.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Long,
    val name: String,
    var owner: Owner,
    @SerializedName("html_url")
    val url: String,
    val description: String,
    @SerializedName("stargazers_count")
    val star: Int,
    val language: String
        ): Parcelable
