package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.Titular;
import com.microservicio.microservicio.service.PersonaService;
import com.microservicio.microservicio.service.TitularService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;

@Slf4j
@RestController
@RequestMapping("/api/titular")
public class TitularController {

    @Autowired
    private TitularService titularService;

    @GetMapping("/listado")
    public Flux<Titular> listar(){
        return titularService.findAll();
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Titular> createPerson(@RequestBody Titular titular){
        LOGGER.info("Hizo la peticion de nuevo");

        return titularService.save(titular);
    }

    @GetMapping("/listado/{idTitular}")
    public Flux<Titular> findPersonById(@PathVariable String idTitular){
        return titularService.findPersonById(idTitular);
    }

    @GetMapping("/listado2/{idTitular}")
    public Flux<Titular> findPersonById2(@PathVariable String idTitular){
        return titularService.buscarporId(idTitular);
    }


    @DeleteMapping("/eliminar/{idTitular}")
    public Mono<Void> deletePerson(@RequestBody Titular titular){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return titularService.eliminar(titular);
    }

    @PutMapping("/actualizar/{idTitular}")
    public Mono<Titular> updatePerson(@RequestBody Titular titular,@PathVariable(value = "idTitular") String idTitular){

        LOGGER.info("Hizo la peticion de actualizar");
        titular.setIdTitular(idTitular);
        return titularService.update(titular);

    }
}
