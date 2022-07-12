package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.TipoCliente;
import com.microservicio.microservicio.repository.PersonaRepository;
import com.microservicio.microservicio.repository.TipoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoClienteServiceImpl implements TipoClienteService{
    @Autowired
    TipoClienteRepository tipoClienteRepository;

    @Override
    public Flux<TipoCliente> findAll() {

        return tipoClienteRepository.findAll();
    }

    @Override
    public Mono<TipoCliente> save(TipoCliente tipoCliente) {

        return tipoClienteRepository.save(tipoCliente);
    }

    @Override
    public Mono<TipoCliente> update(TipoCliente tipoCliente) {

        return null;
    }

    @Override
    public Flux<TipoCliente> findPersonById(String idTipoCliente) {
        return tipoClienteRepository.findAll().filter(x->x.getIdTipoCliente().equals(idTipoCliente));
    }

    @Override
    public Mono<Void> eliminar(TipoCliente tipoCliente){

        return tipoClienteRepository.delete(tipoCliente);
    }

    public Flux<TipoCliente> buscarporId(String idTipoCliente){

        return tipoClienteRepository.buscarporId(idTipoCliente);
    }
}
