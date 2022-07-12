package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonaRepository extends ReactiveCrudRepository<Persona,String> {

    @Query("{'idPersona':?0}")
    Flux<Persona> buscarporIdPersona(String idPersona);

}

