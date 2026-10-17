package org.connecttag.services.webserver.di

import org.connecttag.services.webserver.ILocalWebServer
import org.connecttag.services.webserver.WebControlServerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
public abstract class LocalWebServerModule {

    @Binds
    @Singleton
    internal abstract fun bindLocalWebServer(
        impl: WebControlServerImpl
    ): ILocalWebServer
}
