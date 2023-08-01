package kr.chs.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.chs.core.network.AmazingMovieNetworkDataSource
import kr.chs.core.network.retrofit.RetrofitAmazingMovieNetwork

@Module
@InstallIn(SingletonComponent::class)
interface FlavoredNetworkModule {

    @Binds
    fun RetrofitAmazingMovieNetwork.binds(): AmazingMovieNetworkDataSource
}