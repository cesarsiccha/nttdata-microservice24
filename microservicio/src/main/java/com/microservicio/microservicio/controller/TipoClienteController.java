package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.TipoCliente;
import com.microservicio.microservicio.repository.TipoClienteRepository;
import com.microservicio.microservicio.service.TipoClienteService;
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
@RequestMapping("/api/tipocliente")
public class TipoClienteController {

    @Autowired
    private TipoClienteService tipoClienteService;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public Flux<TipoCliente> getAllClients(){
        LOGGER.info("Hizo la peticion de listado");
        return tipoClienteService.findAll();
    }


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TipoCliente> createClient(@RequestBody TipoCliente tipocliente){
        LOGGER.info("Hizo la peticion de nuevo");

        return tipoClienteService.save(tipocliente);
    }

    @GetMapping("/listado/{idTipoCliente}")
        public Flux<TipoCliente> findPersonById(@PathVariable String idTipoCliente){
            return tipoClienteService.findPersonById(idTipoCliente);
    }

    @DeleteMapping("/eliminar/{idTipoCliente}")
    public Mono<Void> deleteClient(@RequestBody TipoCliente tipoCliente){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return tipoClienteService.eliminar(tipoCliente);
    }

    @PutMapping("/actualizar/{idTipoCliente}")
    public Mono<TipoCliente> updateClient(@RequestBody TipoCliente tipocliente,@PathVariable(value = "idTipoCliente") String idTipoCliente){

        LOGGER.info("Hizo la peticion de actualizar");
        tipocliente.setIdTipoCliente(idTipoCliente);
        return tipoClienteService.update(tipocliente);

    }
}
