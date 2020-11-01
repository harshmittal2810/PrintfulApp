package com.harsh.printfulapp.ui.repo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    fun provideTCPClient(): TcpClient {
        return TcpClient()
    }
}