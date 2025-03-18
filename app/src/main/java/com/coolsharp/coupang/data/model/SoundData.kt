package com.coolsharp.coupang.data.model

data class SoundsData(
    val groups: List<Group>
)

data class Group(
    val packageName: String,
    val groupId: Int,
    val title: Title,
    val items: List<Item>
)

data class Title(
    val eng: String,
    val kor: String
)

data class Item(
    val id: Int,
    val new: Boolean,
    val hq: Boolean,
    val volume: Double,
    val imageInfo: ImageInfo,
    val title: Title
)

data class ImageInfo(
    val width: String,
    val height: String
)