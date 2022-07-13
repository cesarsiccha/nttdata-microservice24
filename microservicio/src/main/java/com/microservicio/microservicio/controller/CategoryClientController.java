package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.CategoryClient;
import com.microservicio.microservicio.service.CategoryClientService;
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
@RequestMapping("/api/tipocliente")
public class CategoryClientController {

    @Autowired
    private CategoryClientService categoryClientService;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CategoryClient> getAllClients(){
        LOGGER.info("Hizo la peticion de listado");
        return categoryClientService.findAll();
    }


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CategoryClient> createClient(@RequestBody CategoryClient tipocliente){
        LOGGER.info("Hizo la peticion de nuevo");

        return categoryClientService.save(tipocliente);
    }

    @GetMapping("/listado/{idTipoCliente}")
        public Flux<CategoryClient> findPersonById(@PathVariable String idTipoCliente){
            return categoryClientService.findPersonById(idTipoCliente);
    }

    @DeleteMapping("/eliminar/{idTipoCliente}")
    public Mono<Void> deleteClient(@RequestBody CategoryClient categoryClient){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return categoryClientService.eliminar(categoryClient);
    }

    @PutMapping("/actualizar/{idTipoCliente}")
    public Mono<CategoryClient> updateClient(@RequestBody CategoryClient tipocliente, @PathVariable(value = "idTipoCliente") String idTipoCliente){

        LOGGER.info("Hizo la peticion de actualizar");
        tipocliente.setIdTipoCliente(idTipoCliente);
        return categoryClientService.update(tipocliente);

    }
}
