package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.Persona;
import com.microservicio.microservicio.model.entity.TipoProducto;
import com.microservicio.microservicio.repository.TipoProductoRepository;
import com.microservicio.microservicio.service.TipoProductoService;
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
@RequestMapping("/api/tipoproducto")
public class TipoProductoController {
    @Autowired
    private TipoProductoService tipoProductoService;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public Flux<TipoProducto> getAllProducts(){
        LOGGER.info("Hizo la peticion de listado");
        return tipoProductoService.findAll();
    }


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TipoProducto> createProduct(@RequestBody TipoProducto tipoProducto){
        LOGGER.info("Hizo la peticion de nuevo");

        return tipoProductoService.save(tipoProducto);
    }

    @GetMapping("/listado/{idTipoProducto}")
    public Flux<TipoProducto> findPersonById(@PathVariable String idTipoProducto){
        return tipoProductoService.findPersonById(idTipoProducto);
    }

    @DeleteMapping("/eliminar/{idTipoProducto}")
    public Mono<Void> deleteProduct(@RequestBody TipoProducto tipoProducto){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return tipoProductoService.eliminar(tipoProducto);

    }

    @PutMapping("/actualizar/{idTipoProducto}")
    public Mono<TipoProducto> updateProduct(@RequestBody TipoProducto tipoProducto,@PathVariable(value = "idTipoProducto") String idTipoProducto){

        LOGGER.info("Hizo la peticion de actualizar");
        tipoProducto.setIdTipoProducto(idTipoProducto);
        return tipoProductoService.save(tipoProducto);

    }
}
