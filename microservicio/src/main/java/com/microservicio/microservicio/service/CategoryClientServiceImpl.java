package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.CategoryClient;
import com.microservicio.microservicio.repository.CategoryClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryClientServiceImpl implements CategoryClientService {
    @Autowired
    CategoryClientRepository categoryClientRepository;

    @Override
    public Flux<CategoryClient> findAll() {

        return categoryClientRepository.findAll();
    }

    @Override
    public Mono<CategoryClient> save(CategoryClient categoryClient) {

        return categoryClientRepository.save(categoryClient);
    }

    @Override
    public Mono<CategoryClient> update(CategoryClient categoryClient) {

        return null;
    }

    @Override
    public Flux<CategoryClient> findPersonById(String idTipoCliente) {
        return categoryClientRepository.findAll().filter(x->x.getIdTipoCliente().equals(idTipoCliente));
    }

    @Override
    public Mono<Void> eliminar(CategoryClient categoryClient){

        return categoryClientRepository.delete(categoryClient);
    }

    public Flux<CategoryClient> buscarporId(String idTipoCliente){

        return categoryClientRepository.buscarporId(idTipoCliente);
    }
}
