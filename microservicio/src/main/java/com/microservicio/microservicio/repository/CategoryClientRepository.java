package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.CategoryClient;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CategoryClientRepository extends ReactiveCrudRepository<CategoryClient,String> {
    @Query("{'idTipoCliente':?0}")
    Flux<CategoryClient> buscarporId(String idTipoCliente);
}
