package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Client;
import com.microservicio.microservicio.model.entity.HolderPerson;
import com.microservicio.microservicio.repository.ClientRepository;
import com.microservicio.microservicio.repository.HolderPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HolderPersonServiceImpl implements HolderPersonService{
    @Autowired
    HolderPersonRepository holderPersonRepository;

    @Override
    public Flux<HolderPerson> findAll() {
        return holderPersonRepository.findAll();
    }

    @Override
    public Mono<HolderPerson> save(HolderPerson holderPerson) {
        return holderPersonRepository.save(holderPerson);
    }

    @Override
    public Mono<HolderPerson> update(HolderPerson holderPerson) {
        return null;
    }

    @Override
    public Flux<HolderPerson> findHolderById(String idHolderPerson) {
        return holderPersonRepository.findAll().filter(x->x.getIdHolderPerson().equals(idHolderPerson));
    }

    @Override
    public Mono<Void> eliminar(HolderPerson holderPerson){
        return holderPersonRepository.delete(holderPerson);
    }
}
