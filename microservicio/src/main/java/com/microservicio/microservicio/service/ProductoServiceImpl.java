package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Producto;
import com.microservicio.microservicio.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Flux<Producto> findAll() {

        return productoRepository.findAll();
    }

    @Override
    public Mono<Producto> save(Producto producto) {

        return productoRepository.save(producto);
    }

    @Override
    public Mono<Producto> update(Producto producto) {

        return null;
    }

    @Override
    public Flux<Producto> findProductById(String idProducto) {
        return productoRepository.findAll().filter(x->x.getIdProducto().equals(idProducto));
    }

    @Override
    public Mono<Void> eliminar(Producto producto){

        return productoRepository.delete(producto);
    }

    public Flux<Producto> buscarporId(String idProducto){

        return productoRepository.buscarporIdProducto(idProducto);
    }
}
