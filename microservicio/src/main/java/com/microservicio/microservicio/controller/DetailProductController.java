package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.DetailProduct;
import com.microservicio.microservicio.service.DetailProductService;

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
@RequestMapping("/api/detalleproducto")
public class DetailProductController {
    @Autowired
    private DetailProductService detailProductService;

    @GetMapping("/listado")
    public Flux<DetailProduct> listar(){
        return detailProductService.findAll();
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DetailProduct> createProduct(@RequestBody DetailProduct detailProduct){
        LOGGER.info("Hizo la peticion de nuevo");

        return detailProductService.save(detailProduct);
    }


    @GetMapping("/listado2/{idDetalleProducto}")
    public Flux<DetailProduct> findProductById(@PathVariable String idDetalleProducto){
        return detailProductService.findbyIdDetailProduct(idDetalleProducto);
    }


    @DeleteMapping("/eliminar/{idDetalleProducto}")
    public Mono<Void> deleteProduct(@RequestBody DetailProduct detailProduct){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return detailProductService.eliminar(detailProduct);
    }

    @PutMapping("/actualizar/{idDetalleProducto}")
    public Mono<DetailProduct> updateProduct(@RequestBody DetailProduct detailProduct, @PathVariable(value = "idDetalleProducto") String idDetalleProducto){

        LOGGER.info("Hizo la peticion de actualizar");
        detailProduct.setIdDetalleProducto(idDetalleProducto);
        return detailProductService.update(detailProduct);

    }
}
