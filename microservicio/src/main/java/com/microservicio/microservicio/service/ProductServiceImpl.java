package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Product;
import com.microservicio.microservicio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Flux<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Mono<Product> save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {

        return null;
    }

    @Override
    public Flux<Product> findProductById(String idProducto) {
        return productRepository.findAll().filter(x->x.getIdProducto().equals(idProducto));
    }

    @Override
    public Mono<Void> eliminar(Product product){

        return productRepository.delete(product);
    }

    public Flux<Product> buscarporId(String idProducto){

        return productRepository.buscarporIdProducto(idProducto);
    }
}
