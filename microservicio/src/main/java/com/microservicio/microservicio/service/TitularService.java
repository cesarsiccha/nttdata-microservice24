package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Titular;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TitularService {
    Flux<Titular> findAll();

    Mono<Titular> save(Titular persona);

    Mono<Titular> update(Titular persona);

    Flux<Titular> findPersonById(String id);

    Mono<Void> eliminar(Titular titular);

    Flux<Titular> buscarporId(String idTitular);
}
