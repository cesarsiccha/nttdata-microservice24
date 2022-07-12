package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.TipoCliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TipoClienteRepository extends ReactiveCrudRepository<TipoCliente,String> {
    @Query("{'idTipoCliente':?0}")
    Flux<TipoCliente> buscarporId(String idTipoCliente);
}
