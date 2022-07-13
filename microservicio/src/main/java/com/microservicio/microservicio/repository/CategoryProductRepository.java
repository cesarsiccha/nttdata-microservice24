package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.CategoryProduct;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CategoryProductRepository extends ReactiveCrudRepository<CategoryProduct,String> {

    @Query("{'idCategoryProduct':?0}")
    Flux<CategoryProduct> buscarporIdTipoProducto(String idTipoProducto);
}
