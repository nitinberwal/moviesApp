package com.example.moviesapp.di

import android.app.Application
import com.example.moviesapp.data.MoviesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviewApplication:Application() {
    override fun onCreate() {
        super.onCreate()
//        startKoin(
//            this@MoviewApplication,
//            myModule
//        )
//        startKoin{
//            androidLogger()
//            androidContext(this@MoviewApplication)
//            modules(modules = myModule)
//        }


    }
}