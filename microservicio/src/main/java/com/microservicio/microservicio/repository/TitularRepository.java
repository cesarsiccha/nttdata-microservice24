package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.Titular;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TitularRepository extends ReactiveCrudRepository<Titular,String> {

    @Query("{'idTitular':?0}")
    Flux<Titular> buscarporIdTitular(String idTitular);
}
