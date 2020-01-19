package com.example.projet.mocks.fake

import com.example.projet.domain.models.ProductEntity
import com.example.projet.domain.utils.Optional
import io.reactivex.Observable

class FakeProductsRepository : ProductsRepository{
    override fun getProducts(): Observable<List<ProductEntity>> {
        return Observable.just(emptyList())
    }

    override fun getProduct(productId: Int): Observable<Optional<ProductEntity>> {
        return Observable.just(Optional(ProductEntity(1,"name",1.0,"description","image")))
    }
}