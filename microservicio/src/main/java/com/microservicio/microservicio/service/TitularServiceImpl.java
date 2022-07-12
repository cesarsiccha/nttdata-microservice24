package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Titular;
import com.microservicio.microservicio.repository.TitularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TitularServiceImpl implements TitularService{

    @Autowired
    TitularRepository titularRepository;

    @Override
    public Flux<Titular> findAll() {

        return titularRepository.findAll();
    }

    @Override
    public Mono<Titular> save(Titular persona) {

        return titularRepository.save(persona);
    }

    @Override
    public Mono<Titular> update(Titular persona) {

        return null;
    }

    @Override
    public Flux<Titular> findPersonById(String idTitular) {
        return titularRepository.findAll().filter(x->x.getIdTitular().equals(idTitular));
    }

    @Override
    public Mono<Void> eliminar(Titular titular){

        return titularRepository.delete(titular);
    }

    public Flux<Titular> buscarporId(String idTitular){
        return titularRepository.buscarporIdTitular(idTitular);
    }
}
