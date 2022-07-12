package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductoRepository extends ReactiveCrudRepository<Producto,String> {
    @Query("{'idProducto':?0}")
    Flux<Producto> buscarporIdProducto(String idProducto);
}
