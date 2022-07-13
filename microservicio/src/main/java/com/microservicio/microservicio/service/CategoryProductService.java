package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.CategoryProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryProductService {

    Flux<CategoryProduct> findAll();

    Mono<CategoryProduct> save(CategoryProduct categoryProduct);

    Mono<CategoryProduct> update(CategoryProduct categoryProduct);

    Flux<CategoryProduct> findPersonById(String idTipoProducto);

    Mono<Void> eliminar(CategoryProduct categoryProduct);

    Flux<CategoryProduct> buscarporId(String idTipoProducto);
}
