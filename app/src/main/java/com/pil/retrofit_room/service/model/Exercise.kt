package com.pil.retrofit_room.service.model

import com.google.gson.annotations.SerializedName

data class Exercise(
    @SerializedName("id")
    var id: Int,
    @SerializedName("license_author")
    var licenseAuthor: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("is_main")
    var isMain: Boolean,
    @SerializedName("license")
    var license: Int
)
