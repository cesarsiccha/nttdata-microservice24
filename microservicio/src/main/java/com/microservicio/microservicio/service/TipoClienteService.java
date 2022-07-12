package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.TipoCliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoClienteService {

    Flux<TipoCliente> findAll();

    Mono<TipoCliente> save(TipoCliente tipoCliente);

    Mono<TipoCliente> update(TipoCliente tipoCliente);

    Flux<TipoCliente> findPersonById(String id);

    Mono<Void> eliminar(TipoCliente tipoCliente);

    Flux<TipoCliente> buscarporId(String idTipoCliente);
}
