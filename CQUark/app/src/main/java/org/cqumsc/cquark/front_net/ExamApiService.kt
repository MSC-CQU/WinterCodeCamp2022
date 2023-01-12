package org.cqumsc.cquark.front_net

import retrofit2.Retrofit
import retrofit2.http.GET
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.cqumsc.cquark.database.ExamInfo
import retrofit2.converter.moshi.MoshiConverterFactory
//BASE_URL待修改
private const val BASE_URL = "http://192.168.10.45:5000"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ExamApiService {
    @GET("realestate") //如果需要指定路径或端点
    suspend fun getInfo():
            List<ExamInfo>
}

//初始化Retrofit
object ExamApi {
    val retrofitService : ExamApiService by lazy {
        retrofit.create(ExamApiService::class.java) }
}

