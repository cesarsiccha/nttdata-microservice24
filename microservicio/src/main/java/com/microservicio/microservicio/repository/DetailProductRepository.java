package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.DetailProduct;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DetailProductRepository extends ReactiveCrudRepository<DetailProduct,String> {
    @Query("{'idDetalleProducto':?0}")
    Flux<DetailProduct> findIdDetailProduct(String idDetalleProducto);

    Mono<DetailProduct> setMaintenance(String idProduct,String idClient);
    Mono<DetailProduct> setMovement(String idProduct,String idClient);
}
