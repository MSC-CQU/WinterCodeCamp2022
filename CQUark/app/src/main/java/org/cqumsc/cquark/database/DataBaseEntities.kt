package org.cqumsc.cquark.database

import com.squareup.moshi.Json

//和后端对接需修改！！
data class ExamInfo(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
)
