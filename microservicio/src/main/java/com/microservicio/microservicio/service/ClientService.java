package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<Client> findAll();

    Mono<Client> save(Client client);

    Mono<Client> update(Client client);

    Flux<Client> findClientById(String id);

    Mono<Void> eliminar(Client client);
}
