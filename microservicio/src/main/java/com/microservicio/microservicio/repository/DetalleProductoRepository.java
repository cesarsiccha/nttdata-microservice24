package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.DetalleProducto;
import com.microservicio.microservicio.model.entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface DetalleProductoRepository extends ReactiveCrudRepository<DetalleProducto,String> {
    @Query("{'idDetalleProducto':?0}")
    Flux<DetalleProducto> buscarporIdDetalleProducto(String idDetalleProducto);
}
