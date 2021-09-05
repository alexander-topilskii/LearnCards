package com.talex.learncards

import com.talex.datasource.Source
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule() {
    @Binds
    abstract fun bindSource(
        @ApplicationContext
        source: Source
    ): Source

}