package com.example.meemeebanks.data.vos

import com.google.gson.annotations.SerializedName

data class BankVO (

    @SerializedName("id")
    val id : Int,

    @SerializedName("name")
    val name : String,

    @SerializedName("description")
    val description : String?,

    @SerializedName("type")
    val type : String,

    @SerializedName("maxAmount")
    val maxAmount : String?,

    @SerializedName("length")
    val length : Int,

    @SerializedName("startColor")
    val startColor : String,

    @SerializedName("centerColor")
    val centerColor : String,

    @SerializedName("endColor")
    val endColor : String,

    @SerializedName("bgColor")
    val bgColor : String,

    @SerializedName("fontColor")
    val fontColor : String,

    @SerializedName("logoUrl")
    val logoUrl : String,

    @SerializedName("logoThumbnail")
    val logoThumbnail : String,

    @SerializedName("instruction1")
    val instruction1 : String,

    @SerializedName("instruction2")
    val instruction2 : String,

    @SerializedName("enabled")
    val enabled : String,

    @SerializedName("created_at")
    val created_at : String,

    @SerializedName("updated_at")
    val updated_at : String,

    @SerializedName("deleted_at")
    val deleted_at : String?,

    @SerializedName("is_major")
    val is_major : Boolean,

    @SerializedName("logo_url")
    val logo_url : Boolean

) {
}