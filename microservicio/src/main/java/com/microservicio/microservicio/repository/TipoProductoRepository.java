package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.TipoProducto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TipoProductoRepository extends ReactiveCrudRepository<TipoProducto,String> {

    @Query("{'idTipoProducto':?0}")
    Flux<TipoProducto> buscarporIdTipoProducto(String idTipoProducto);
}
