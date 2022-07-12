package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.TipoCliente;
import com.microservicio.microservicio.model.entity.TipoProducto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoProductoService {

    Flux<TipoProducto> findAll();

    Mono<TipoProducto> save(TipoProducto tipoProducto);

    Mono<TipoProducto> update(TipoProducto tipoProducto);

    Flux<TipoProducto> findPersonById(String idTipoProducto);

    Mono<Void> eliminar(TipoProducto tipoProducto);

    Flux<TipoProducto> buscarporId(String idTipoProducto);
}
