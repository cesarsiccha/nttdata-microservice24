package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.Client;
import com.microservicio.microservicio.service.ClientService;
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
@RequestMapping("/api/cliente")

public class ClientController {

    @Autowired
    private ClientService clientService;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Client> getAllClients(){
        LOGGER.info("Hizo la peticion de listado");
        return clientService.findAll();
    }


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Client> createClient(@RequestBody Client client){
        LOGGER.info("Hizo la peticion de nuevo");

        return clientService.save(client);
    }

    @GetMapping("/listado/{idClient}")
    public Flux<Client> getClient(@PathVariable String idClient){
            return clientService.findClientById(idClient);

    }

    @DeleteMapping("/eliminar/{idClient}")
    public Mono<Void> deleteClient(@RequestBody Client client){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return clientService.eliminar(client);

    }

    @PutMapping("/actualizar/{idCliente}")
    public Client updateClient(@RequestBody Client client, @PathVariable(value = "idClient") String idClient){

        LOGGER.info("Hizo la peticion de actualizar");
        client.setIdClient(idClient);
        clientService.save(client);

        return client;
    }
}
