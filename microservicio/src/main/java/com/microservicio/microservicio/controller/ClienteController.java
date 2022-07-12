package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.Cliente;
import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.repository.ClienteRepository;
import com.microservicio.microservicio.service.ClienteService;
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
@RequestMapping("/api/cliente")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Cliente> getAllClients(){
        LOGGER.info("Hizo la peticion de listado");
        return clienteService.findAll();
    }


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Cliente> createClient(@RequestBody Cliente cliente){
        LOGGER.info("Hizo la peticion de nuevo");

        return clienteService.save(cliente);
    }

    @GetMapping("/listado/{idCliente}")
    public Flux<Cliente> getClient(@PathVariable String idCliente){
            return clienteService.findPersonById(idCliente);

    }

    @DeleteMapping("/eliminar/{idCliente}")
    public Mono<Void> deleteClient(@RequestBody Cliente cliente){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return clienteService.eliminar(cliente);

    }

    @PutMapping("/actualizar/{idCliente}")
    public Cliente updateClient(@RequestBody Cliente cliente,@PathVariable(value = "idCliente") String idCliente){

        LOGGER.info("Hizo la peticion de actualizar");
        cliente.setIdCliente(idCliente);
        clienteService.save(cliente);

        return cliente;
    }
}
