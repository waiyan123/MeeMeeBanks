package com.example.meemeebanks.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "bank_table")
data class BankVO (

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name="id")
    val id : Int,

    @SerializedName("name")
    @ColumnInfo(name="name")
    val name : String,

    @SerializedName("description")
    @ColumnInfo(name="description")
    val description : String?,

    @SerializedName("type")
    @ColumnInfo(name="type")
    val type : String,

    @SerializedName("maxAmount")
    @ColumnInfo(name="maxAmount")
    val maxAmount : String?,

    @SerializedName("length")
    @ColumnInfo(name="length")
    val length : Int,

    @SerializedName("startColor")
    @ColumnInfo(name="startColor")
    val startColor : String,

    @SerializedName("centerColor")
    @ColumnInfo(name="centerColor")
    val centerColor : String,

    @SerializedName("endColor")
    @ColumnInfo(name="endColor")
    val endColor : String,

    @SerializedName("bgColor")
    @ColumnInfo(name="bgColor")
    val bgColor : String,

    @SerializedName("fontColor")
    @ColumnInfo(name="fontColor")
    val fontColor : String,

    @SerializedName("logoUrl")
    @ColumnInfo(name="logoUrl")
    val logoUrl : String,

    @SerializedName("logoThumbnail")
    @ColumnInfo(name="logoThumbnail")
    val logoThumbnail : String,

    @SerializedName("instruction1")
    @ColumnInfo(name="instruction1")
    val instruction1 : String,

    @SerializedName("instruction2")
    @ColumnInfo(name="instruction2")
    val instruction2 : String,

    @SerializedName("enabled")
    @ColumnInfo(name="enabled")
    val enabled : String,

    @SerializedName("created_at")
    @ColumnInfo(name="created_at")
    val created_at : String,

    @SerializedName("updated_at")
    @ColumnInfo(name="updated_at")
    val updated_at : String,

    @SerializedName("deleted_at")
    @ColumnInfo(name="deleted_at")
    val deleted_at : String?,

    @SerializedName("is_major")
    @ColumnInfo(name="is_major")
    val is_major : Boolean,

    @SerializedName("logo_url")
    @ColumnInfo(name="logo_url")
    val logo_url : String

) : Serializable{
}