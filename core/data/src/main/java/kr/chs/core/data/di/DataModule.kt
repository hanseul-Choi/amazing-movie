package kr.chs.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.chs.core.data.repository.SearchRepository
import kr.chs.core.data.repository.SearchRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsSearchRepository(
        searchRepository: SearchRepositoryImpl
    ): SearchRepository
}