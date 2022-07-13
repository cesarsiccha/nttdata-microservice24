package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.CategoryProduct;
import com.microservicio.microservicio.repository.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {
    @Autowired
    CategoryProductRepository categoryProductRepository;

    @Override
    public Flux<CategoryProduct> findAll() {

        return categoryProductRepository.findAll();
    }

    @Override
    public Mono<CategoryProduct> save(CategoryProduct categoryProduct) {

        return categoryProductRepository.save(categoryProduct);
    }

    @Override
    public Mono<CategoryProduct> update(CategoryProduct categoryProduct) {

        return null;
    }

    @Override
    public Flux<CategoryProduct> findPersonById(String idTipoProducto) {
        return categoryProductRepository.findAll().filter(x->x.getIdCategoryProduct().equals(idTipoProducto));
    }

    @Override
    public Mono<Void> eliminar(CategoryProduct categoryProduct){

        return categoryProductRepository.delete(categoryProduct);
    }

    public Flux<CategoryProduct> buscarporId(String idTipoProducto){

        return categoryProductRepository.buscarporIdTipoProducto(idTipoProducto);
    }
}
