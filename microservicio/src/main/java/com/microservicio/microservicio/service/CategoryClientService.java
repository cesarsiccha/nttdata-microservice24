package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.CategoryClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryClientService {

    Flux<CategoryClient> findAll();

    Mono<CategoryClient> save(CategoryClient categoryClient);

    Mono<CategoryClient> update(CategoryClient categoryClient);

    Flux<CategoryClient> findPersonById(String id);

    Mono<Void> eliminar(CategoryClient categoryClient);

    Flux<CategoryClient> buscarporId(String idTipoCliente);
}
