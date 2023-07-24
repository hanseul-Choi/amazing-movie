package kr.chs.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.chs.core.network.BuildConfig
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class TMDB

    // API_TOKEN Interceptor
    @Provides
    @TMDB
    fun provideTMDBTokenInterceptor() : Interceptor = Interceptor { chain ->
        with(chain) {
            val newRequest = request().newBuilder()
                .addHeader("Authorization", "Bearer ${BuildConfig.TMDB_API_KEY}")
                .build()
            proceed(newRequest)
        }
    }

    // default : No Log
    @Provides
    @Singleton
    @TMDB
    fun provideHttpCallFactory(
        tmdbInterceptor: Interceptor
    ) : Call.Factory = OkHttpClient.Builder()
        .addInterceptor(tmdbInterceptor)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                if(BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            }
        ).build()
}