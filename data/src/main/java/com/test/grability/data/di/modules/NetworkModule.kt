package com.test.grability.data.di.modules

import android.content.Context
import com.test.grability.data.BuildConfig
import com.test.grability.data.remote.util.MarvelAPIUtils
import dagger.Module
import dagger.Provides
import okhttp3.*

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    @FeatureScope
    fun provideHttpCache(context: Context): Cache {
        val cacheSize: Long = 10 * 10 * 1024
        return Cache(context.cacheDir, cacheSize)
    }

    @Provides
    @FeatureScope
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }


    @Provides
    @FeatureScope
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)

            client.addInterceptor(loggingInterceptor)

        client.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url


            val authPair = MarvelAPIUtils().getAuthorizationValues()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("ts",  authPair.first)
                .addQueryParameter("apikey", authPair.second)
                .addQueryParameter("hash",  authPair.third)
                .addQueryParameter("limit", "100")
                .build()

            val requestBuilder = original.newBuilder().url(url)

            chain.proceed(requestBuilder.build())
        }
        return client.build()
    }

    @Provides
    @FeatureScope
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.MARVEL_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


}