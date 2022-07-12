package com.microservicio.microservicio.service;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Flux<Persona> findAll() {

        return personaRepository.findAll();
    }

    @Override
    public Mono<Persona> save(Persona persona) {

        return personaRepository.save(persona);
    }

    @Override
    public Mono<Persona> update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Mono<Persona> findPersonById(String idPersona) {
        return personaRepository.findById(idPersona);
    }

    @Override
    public Mono<Void> eliminar(Persona persona){

        return personaRepository.delete(persona);
    }

    public Flux<Persona> buscarporId(String idPersona){
        return personaRepository.buscarporIdPersona(idPersona);
    }
}
