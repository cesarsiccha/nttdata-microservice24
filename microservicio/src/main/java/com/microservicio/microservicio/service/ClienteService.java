package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Cliente;
import com.microservicio.microservicio.model.entity.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
    Flux<Cliente> findAll();

    Mono<Cliente> save(Cliente cliente);

    Mono<Cliente> update(Cliente cliente);

    Flux<Cliente> findPersonById(String id);

    Mono<Void> eliminar(Cliente cliente);
}
