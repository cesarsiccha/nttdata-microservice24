package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.DetailProduct;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface DetailProductRepository extends ReactiveCrudRepository<DetailProduct,String> {
    @Query("{'idDetalleProducto':?0}")
    Flux<DetailProduct> buscarporIdDetalleProducto(String idDetalleProducto);
}
