package com.example.projet.data.remote

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.nio.charset.Charset

@RunWith(JUnit4::class)
class RemoteServiceTest {

    private lateinit var webService: RemoteService
    private lateinit var mockWebServer: MockWebServer

    @Throws(IOException::class)
    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        webService = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(mockWebServer.url("/"))
            .client(OkHttpClient())
            .build()
            .create(RemoteService::class.java)
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
            override fun isMainThread() = true
            override fun postToMainThread(runnable: Runnable) = runnable.run()
        })
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}