package com.mehedi.mvvmcleanecomrestapi.data.model.product


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class ResponseProductItem(
    @SerializedName("category")
    val category: Category? = null,
    @SerializedName("creationAt")
    val creationAt: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("images")
    val images: List<String?>? = null,
    @SerializedName("price")
    val price: Long? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null
) {
    @Keep
    data class Category(
        @SerializedName("creationAt")
        val creationAt: String? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("image")
        val image: String? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("updatedAt")
        val updatedAt: String? = null
    )
}
