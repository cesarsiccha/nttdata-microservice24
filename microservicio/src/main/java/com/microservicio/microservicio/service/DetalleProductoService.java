package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.DetalleProducto;
import com.microservicio.microservicio.model.entity.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DetalleProductoService {
    Flux<DetalleProducto> findAll();

    Mono<DetalleProducto> save(DetalleProducto detalleProducto);

    Mono<DetalleProducto> update(DetalleProducto detalleProducto);

    Flux<DetalleProducto> findPersonById(String id);

    Mono<Void> eliminar(DetalleProducto detalleProducto);

    Flux<DetalleProducto> buscarporId(String idDetalleProducto);
}
