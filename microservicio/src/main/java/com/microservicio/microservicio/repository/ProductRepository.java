package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveCrudRepository<Product,String> {
    @Query("{'idProducto':?0}")
    Flux<Product> buscarporIdProducto(String idProducto);
}
