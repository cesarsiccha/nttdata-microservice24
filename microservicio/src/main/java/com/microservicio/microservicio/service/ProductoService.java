package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {
    Flux<Producto> findAll();

    Mono<Producto> save(Producto producto);

    Mono<Producto> update(Producto producto);

    Flux<Producto> findPersonById(String id);

    Mono<Void> eliminar(Producto producto);

    Flux<Producto> buscarporId(String idProducto);
}
