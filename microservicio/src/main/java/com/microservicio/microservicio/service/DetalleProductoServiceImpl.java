package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.DetalleProducto;
import com.microservicio.microservicio.model.entity.Producto;
import com.microservicio.microservicio.repository.DetalleProductoRepository;
import com.microservicio.microservicio.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DetalleProductoServiceImpl implements DetalleProductoService {

    @Autowired
    DetalleProductoRepository detalleProductoRepository;

    @Override
    public Flux<DetalleProducto> findAll() {

        return detalleProductoRepository.findAll();
    }

    @Override
    public Mono<DetalleProducto> save(DetalleProducto detalleProducto) {

        return detalleProductoRepository.save(detalleProducto);
    }

    @Override
    public Mono<DetalleProducto> update(DetalleProducto detalleProducto) {

        return null;
    }

    @Override
    public Flux<DetalleProducto> findPersonById(String idDetalleProducto) {
        return detalleProductoRepository.findAll().filter(x->x.getIdDetalleProducto().equals(idDetalleProducto));
    }

    @Override
    public Mono<Void> eliminar(DetalleProducto detalleProducto){

        return detalleProductoRepository.delete(detalleProducto);
    }

    public Flux<DetalleProducto> buscarporId(String idDetalleProducto){

        return detalleProductoRepository.buscarporIdDetalleProducto(idDetalleProducto);
    }
}
