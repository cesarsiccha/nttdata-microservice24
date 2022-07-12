package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.DetalleProducto;
import com.microservicio.microservicio.service.DetalleProductoService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/detalleproducto")
public class DetalleProductoController {
    @Autowired
    private DetalleProductoService detalleProductoService;

    @GetMapping("/listado")
    public Flux<DetalleProducto> listar(){
        return detalleProductoService.findAll();
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DetalleProducto> createProduct(@RequestBody DetalleProducto detalleProducto){
        LOGGER.info("Hizo la peticion de nuevo");

        return detalleProductoService.save(detalleProducto);
    }

    @GetMapping("/listado/{idDetalleProducto}")
    public Flux<DetalleProducto> findPersonById(@PathVariable String idDetalleProducto){
        return detalleProductoService.findPersonById(idDetalleProducto);
    }

    @GetMapping("/listado2/{idDetalleProducto}")
    public Flux<DetalleProducto> findProductById2(@PathVariable String idDetalleProducto){
        return detalleProductoService.buscarporId(idDetalleProducto);
    }


    @DeleteMapping("/eliminar/{idDetalleProducto}")
    public Mono<Void> deleteProduct(@RequestBody DetalleProducto detalleProducto){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return detalleProductoService.eliminar(detalleProducto);
    }

    @PutMapping("/actualizar/{idDetalleProducto}")
    public Mono<DetalleProducto> updateProduct(@RequestBody DetalleProducto detalleProducto,@PathVariable(value = "idDetalleProducto") String idDetalleProducto){

        LOGGER.info("Hizo la peticion de actualizar");
        detalleProducto.setIdDetalleProducto(idDetalleProducto);
        return detalleProductoService.update(detalleProducto);

    }
}
