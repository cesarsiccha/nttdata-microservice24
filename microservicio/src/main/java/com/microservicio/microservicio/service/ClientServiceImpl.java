package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Client;
import com.microservicio.microservicio.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Flux<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> update(Client client) {
        return null;
    }

    @Override
    public Flux<Client> findClientById(String idClient) {
        return clientRepository.findAll().filter(x->x.getIdClient().equals(idClient));
    }

    @Override
    public Mono<Void> eliminar(Client client){
        return clientRepository.delete(client);
    }
}
