package com.example.projet.di

import android.app.Application
import androidx.room.Room
import com.example.projet.data.local.*
import com.example.projet.data.remote.RemoteService
import com.example.projet.data.repository.*
import com.example.projet.domain.repository.*
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.annotations.NonNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://demo2481139.mockable.io")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRemoteService(@NonNull retrofit: Retrofit): RemoteService {
        return retrofit.create(RemoteService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room.databaseBuilder(application.applicationContext, AppDatabase::class.java, "database.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    @Inject
    fun providePersonRepositoryImpl(
        remoteService: RemoteService,
        personDao: PersonDao
    ): PersonRepository {
        return PersonRepositoryImpl(remoteService, personDao)
    }

    @Provides
    @Singleton
    @Inject
    fun provideRevenuesRepository(
        remoteService: RemoteService,
        revenueDao: RevenueDao
    ): RevenuesRepository {
        return RevenuesRepositoryImpl(remoteService, revenueDao)
    }

    @Provides
    @Singleton
    @Inject
    fun provideScreenRepository(
        @NonNull application: Application,
        screenDao: ScreenDao
    ): ScreenRepository {
        return ScreensRepositoryImpl(application, screenDao)
    }

    @Provides
    @Singleton
    @Inject
    fun provideBulletinRepository(
        remoteService: RemoteService,
        bulletinDao: BulletinDao
    ): BulletinRepository {
        return BulletinRepositoryImpl(remoteService, bulletinDao)
    }

    @Provides
    @Singleton
    fun providePersonDao(@NonNull database: AppDatabase): PersonDao {
        return database.personDao()
    }

    @Provides
    @Singleton
    fun provideScreenDao(@NonNull database: AppDatabase): ScreenDao {
        return database.screenDao()
    }

    @Provides
    @Singleton
    fun provideRevenueDao(@NonNull database: AppDatabase): RevenueDao {
        return database.revenueDao()
    }

    @Provides
    @Singleton
    fun provideBulletinDao(@NonNull database: AppDatabase): BulletinDao {
        return database.bulletinDao()
    }

}