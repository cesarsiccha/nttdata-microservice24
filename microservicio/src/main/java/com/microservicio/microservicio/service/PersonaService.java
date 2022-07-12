package com.microservicio.microservicio.service;

import reactor.core.publisher.Flux;
import com.microservicio.microservicio.model.entity.Persona;
import reactor.core.publisher.Mono;

public interface PersonaService {
    Flux<Persona> findAll();

    Mono<Persona> save(Persona persona);

    Mono<Persona> update(Persona persona);

    Mono<Persona> findPersonById(String id);

    Mono<Void> eliminar(Persona persona);

    Flux<Persona> buscarporId(String idPersona);
}
