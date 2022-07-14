package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.HolderPerson;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HolderPersonService {
    Flux<HolderPerson> findAll();

    Mono<HolderPerson> save(HolderPerson holderPerson);

    Mono<HolderPerson> update(HolderPerson holderPerson);

    Flux<HolderPerson> findHolderById(String id);

    Mono<Void> eliminar(HolderPerson holderPerson);
}
