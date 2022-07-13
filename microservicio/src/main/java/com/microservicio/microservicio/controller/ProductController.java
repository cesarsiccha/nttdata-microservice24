package com.microservicio.microservicio.controller;


import com.microservicio.microservicio.model.entity.Product;
import com.microservicio.microservicio.service.ProductService;
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
@RequestMapping("/api/producto")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/listado")
    public Flux<Product> listar(){
        return productService.findAll();
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> createProduct(@RequestBody Product product){
        LOGGER.info("Hizo la peticion de nuevo");

        return productService.save(product);
    }

    @GetMapping("/listado/{idProducto}")
    public Flux<Product> findProductById(@PathVariable String idProducto){
        return productService.findProductById(idProducto);
    }

    @GetMapping("/listado2/{idProducto}")
    public Flux<Product> findProductById2(@PathVariable String idProducto){
        return productService.buscarporId(idProducto);
    }


    @DeleteMapping("/eliminar/{idProducto}")
    public Mono<Void> deleteProduct(@RequestBody Product product){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return productService.eliminar(product);
    }

    @PutMapping("/actualizar/{idProducto}")
    public Mono<Product> updateProduct(@RequestBody Product product, @PathVariable(value = "idProducto") String idProducto){

        LOGGER.info("Hizo la peticion de actualizar");
        product.setIdProducto(idProducto);
        return productService.update(product);

    }
}
