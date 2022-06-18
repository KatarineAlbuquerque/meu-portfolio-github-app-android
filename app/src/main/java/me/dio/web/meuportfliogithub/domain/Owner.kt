package me.dio.web.meuportfliogithub.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(
    val name: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
): Parcelable