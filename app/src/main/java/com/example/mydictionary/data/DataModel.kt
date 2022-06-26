package com.example.mydictionary.data

import com.google.gson.annotations.SerializedName

class DataModel(
    // я попробовала убрать аннотацию   @field, но студия начала ругаться:(

    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<Meanings>?
)