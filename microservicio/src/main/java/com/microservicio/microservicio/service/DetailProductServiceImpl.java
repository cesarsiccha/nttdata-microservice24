package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.DetailProduct;
import com.microservicio.microservicio.repository.DetailProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DetailProductServiceImpl implements DetailProductService {

    @Autowired
    DetailProductRepository detailProductRepository;

    @Override
    public Flux<DetailProduct> findAll() {

        return detailProductRepository.findAll();
    }

    @Override
    public Mono<DetailProduct> save(DetailProduct detailProduct) {

        return detailProductRepository.save(detailProduct);
    }

    @Override
    public Mono<DetailProduct> update(DetailProduct detailProduct) {

        return null;
    }

    @Override
    public Flux<DetailProduct> findPersonById(String idDetalleProducto) {
        return detailProductRepository.findAll().filter(x->x.getIdDetalleProducto().equals(idDetalleProducto));
    }

    @Override
    public Mono<Void> eliminar(DetailProduct detailProduct){

        return detailProductRepository.delete(detailProduct);
    }

    public Flux<DetailProduct> buscarporId(String idDetalleProducto){

        return detailProductRepository.buscarporIdDetalleProducto(idDetalleProducto);
    }
}
