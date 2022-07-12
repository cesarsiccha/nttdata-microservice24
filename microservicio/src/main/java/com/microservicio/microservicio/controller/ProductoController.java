package com.microservicio.microservicio.controller;


import com.microservicio.microservicio.model.entity.Producto;
import com.microservicio.microservicio.service.ProductoService;
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
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public Flux<Producto> listar(){
        return productoService.findAll();
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Producto> createProduct(@RequestBody Producto producto){
        LOGGER.info("Hizo la peticion de nuevo");

        return productoService.save(producto);
    }

    @GetMapping("/listado/{idProducto}")
    public Flux<Producto> findPersonById(@PathVariable String idProducto){
        return productoService.findPersonById(idProducto);
    }

    @GetMapping("/listado2/{idProducto}")
    public Flux<Producto> findProductById2(@PathVariable String idProducto){
        return productoService.buscarporId(idProducto);
    }


    @DeleteMapping("/eliminar/{idProducto}")
    public Mono<Void> deleteProduct(@RequestBody Producto producto){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return productoService.eliminar(producto);
    }

    @PutMapping("/actualizar/{idProducto}")
    public Mono<Producto> updateProduct(@RequestBody Producto producto,@PathVariable(value = "idProducto") String idProducto){

        LOGGER.info("Hizo la peticion de actualizar");
        producto.setIdProducto(idProducto);
        return productoService.update(producto);

    }
}
