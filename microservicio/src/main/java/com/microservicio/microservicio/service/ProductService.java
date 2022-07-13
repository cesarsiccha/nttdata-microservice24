package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> findAll();

    Mono<Product> save(Product product);

    Mono<Product> update(Product product);

    Flux<Product> findProductById(String id);

    Mono<Void> eliminar(Product product);

    Flux<Product> buscarporId(String idProducto);
}
