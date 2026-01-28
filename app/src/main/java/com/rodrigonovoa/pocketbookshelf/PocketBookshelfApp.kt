package com.rodrigonovoa.pocketbookshelf

import android.app.Application
import com.rodrigonovoa.pocketbookshelf.di.dataModule
import com.rodrigonovoa.pocketbookshelf.di.domainModule
import com.rodrigonovoa.pocketbookshelf.di.networkModule
import com.rodrigonovoa.pocketbookshelf.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PocketBookshelfApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PocketBookshelfApp)
            modules(
                networkModule,
                dataModule,
                domainModule,
                viewModelModule
            )
        }
    }
}