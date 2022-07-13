package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.DetailProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DetailProductService {
    Flux<DetailProduct> findAll();

    Mono<DetailProduct> save(DetailProduct detailProduct);

    Mono<DetailProduct> update(DetailProduct detailProduct);

    Flux<DetailProduct> findPersonById(String id);

    Mono<Void> eliminar(DetailProduct detailProduct);

    Flux<DetailProduct> buscarporId(String idDetalleProducto);
}
