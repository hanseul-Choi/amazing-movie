package kr.chs.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.chs.core.network.BuildConfig
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // default : No Log
    @Provides
    @Singleton
    fun provideHttpCallFactory() : Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                if(BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            }
        ).build()
}