package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.DetailProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DetailProductService {
    Flux<DetailProduct> findAll();

    Mono<DetailProduct> save(DetailProduct detailProduct);

    Mono<DetailProduct> update(DetailProduct detailProduct);


    Mono<Void> eliminar(DetailProduct detailProduct);

    Flux<DetailProduct> findbyIdDetailProduct(String idDetalleProducto);

    Mono<DetailProduct> setMaintment(String idProduct,String idClient);

    Mono<DetailProduct> setMovement(String idProduct,String idClient);
}
