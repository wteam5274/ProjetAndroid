package com.example.projet.mocks.di.modules

import com.example.projet.mocks.fake.FakeProductsRepository
import com.example.projet.mocks.fake.FakeUserRepository
import dagger.Provides
import javax.inject.Singleton

class TestAppModule(
    private val userRepository: UserRepository = FakeUserRepository(),
    private val productsRepository: ProductsRepository = FakeProductsRepository()
) {

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository {
        return userRepository
    }

    @Provides
    @Singleton
    fun provideProductsRepository(): ProductsRepository {
        return productsRepository
    }
}