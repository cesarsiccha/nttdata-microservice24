package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.TipoProducto;
import com.microservicio.microservicio.repository.TipoClienteRepository;
import com.microservicio.microservicio.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoProductoServiceImpl implements TipoProductoService{
    @Autowired
    TipoProductoRepository tipoProductoRepository;

    @Override
    public Flux<TipoProducto> findAll() {

        return tipoProductoRepository.findAll();
    }

    @Override
    public Mono<TipoProducto> save(TipoProducto tipoProducto) {

        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public Mono<TipoProducto> update(TipoProducto tipoProducto) {

        return null;
    }

    @Override
    public Flux<TipoProducto> findPersonById(String idTipoProducto) {
        return tipoProductoRepository.findAll().filter(x->x.getIdTipoProducto().equals(idTipoProducto));
    }

    @Override
    public Mono<Void> eliminar(TipoProducto tipoProducto){

        return tipoProductoRepository.delete(tipoProducto);
    }

    public Flux<TipoProducto> buscarporId(String idTipoProducto){

        return tipoProductoRepository.buscarporIdTipoProducto(idTipoProducto);
    }
}
