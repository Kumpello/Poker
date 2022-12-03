package com.kumpello.poker.domain.model

import com.kumpello.poker.domain.usecase.Authentication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideAuthentication(): Authentication {
        return Authentication()
    }

}