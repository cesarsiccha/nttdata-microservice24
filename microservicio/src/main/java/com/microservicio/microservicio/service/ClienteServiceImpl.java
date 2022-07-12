package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Cliente;
import com.microservicio.microservicio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Flux<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Mono<Cliente> save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Mono<Cliente> update(Cliente cliente) {
        return null;
    }

    @Override
    public Flux<Cliente> findPersonById(String idCliente) {
        return clienteRepository.findAll().filter(x->x.getIdCliente().equals(idCliente));
    }

    @Override
    public Mono<Void> eliminar(Cliente cliente){
        return clienteRepository.delete(cliente);
    }
}
