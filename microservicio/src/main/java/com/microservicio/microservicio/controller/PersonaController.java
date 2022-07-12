package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.repository.PersonaRepository;
import com.microservicio.microservicio.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/persona")
public class PersonaController {



    @Autowired
    private PersonaService personaService;

    @GetMapping("/listado")
    public Flux<Persona> listar(){
        return personaService.findAll();
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Persona> createPerson(@RequestBody Persona persona){
        LOGGER.info("Hizo la peticion de nuevo");

        return personaService.save(persona);
    }

    @GetMapping("/listado/{idPersona}")
    public Flux<Persona> findPersonById(@PathVariable String idPersona){
        return personaService.findPersonById(idPersona);
    }

    @GetMapping("/listado2/{idPersona}")
    public Flux<Persona> findPersonById2(@PathVariable String idPersona){
        return personaService.buscarporId(idPersona);
    }


    @DeleteMapping("/eliminar/{idPersona}")
    public Mono<Void> deletePerson(@RequestBody Persona persona){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return personaService.eliminar(persona);
    }

    @PutMapping("/actualizar/{idPersona}")
    public Mono<Persona> updatePerson(@RequestBody Persona persona,@PathVariable(value = "idPersona") String idPersona){

        LOGGER.info("Hizo la peticion de actualizar");
        persona.setIdPersona(idPersona);
        return personaService.update(persona);

    }
}
