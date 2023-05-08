package com.kumpello.poker.domain.model

import com.kumpello.poker.domain.usecase.AuthenticationService
import com.kumpello.poker.domain.usecase.OrganizationsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideAuthentication(): AuthenticationService {
        return AuthenticationService()
    }

    @Provides
    fun providesOrganizations(): OrganizationsService {
        return OrganizationsService()
    }
}