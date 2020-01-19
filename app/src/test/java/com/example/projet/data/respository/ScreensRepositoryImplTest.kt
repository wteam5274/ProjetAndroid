package com.example.projet.data.respository

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.projet.data.local.ScreenDao
import com.example.projet.data.remote.RemoteService
import com.example.projet.data.repository.ScreensRepositoryImpl
import com.example.projet.utils.TestsUtils
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class ScreensRepositoryImplTest {

    private lateinit var screenDao: ScreenDao
    private lateinit var remoteService: RemoteService
    private lateinit var screensRepositoryImpl: ScreensRepositoryImpl
    private lateinit var application: Application
    private val testScheduler = TestScheduler()
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun before() {
        screenDao = mock(ScreenDao::class.java)
        remoteService = mock(RemoteService::class.java)
        application = mock(Application::class.java)
        screensRepositoryImpl = ScreensRepositoryImpl(application,screenDao)
    }

    @Test
    fun getScreensWhenCacheIsFull() {
        val list = TestsUtils.generateOnBoardingEntityList()
        whenever(screenDao.getScreens()).thenReturn(list)
        screensRepositoryImpl.getScreens()
        testScheduler.triggerActions()
        verify(screenDao).getScreens()
    }
}