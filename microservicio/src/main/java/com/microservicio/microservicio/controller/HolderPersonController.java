package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.HolderPerson;
import com.microservicio.microservicio.service.HolderPersonService;
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

public class HolderPersonController {
    @Autowired
    private HolderPersonService holderPersonService;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public Flux<HolderPerson> getAllClients(){
        LOGGER.info("Hizo la peticion de listado");
        return holderPersonService.findAll();
    }


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<HolderPerson> createClient(@RequestBody HolderPerson holderPerson){
        LOGGER.info("Hizo la peticion de nuevo");

        return holderPersonService.save(holderPerson);
    }

    @GetMapping("/listado/{idHolderPerson}")
    public Flux<HolderPerson> getClient(@PathVariable String idHolderPerson){
        return holderPersonService.findHolderById(idHolderPerson);

    }

    @DeleteMapping("/eliminar/{idHolderPerson}")
    public Mono<Void> deleteClient(@RequestBody HolderPerson holderPerson){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return holderPersonService.eliminar(holderPerson);

    }

    @PutMapping("/actualizar/{idHolderPerson}")
    public HolderPerson updateClient(@RequestBody HolderPerson holderPerson, @PathVariable(value = "idHolderPerson") String idHolderPerson){

        LOGGER.info("Hizo la peticion de actualizar");
        holderPerson.setIdHolderPerson(idHolderPerson);
        holderPersonService.save(holderPerson);

        return holderPerson;
    }
}
