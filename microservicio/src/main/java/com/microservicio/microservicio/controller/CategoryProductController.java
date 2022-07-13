package com.microservicio.microservicio.controller;

import com.microservicio.microservicio.model.entity.CategoryProduct;
import com.microservicio.microservicio.service.CategoryProductService;
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
@RequestMapping("/api/tipoproducto")
public class CategoryProductController {
    @Autowired
    private CategoryProductService categoryProductService;

    private static final Logger LOGGER= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CategoryProduct> getAllProducts(){
        LOGGER.info("Hizo la peticion de listado");
        return categoryProductService.findAll();
    }


    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CategoryProduct> createProduct(@RequestBody CategoryProduct categoryProduct){
        LOGGER.info("Hizo la peticion de nuevo");

        return categoryProductService.save(categoryProduct);
    }

    @GetMapping("/listado/{idCategoryProduct}")
    public Flux<CategoryProduct> findPersonById(@PathVariable String idCategoryProduct){
        return categoryProductService.findPersonById(idCategoryProduct);
    }

    @DeleteMapping("/eliminar/{idCategoryProduct}")
    public Mono<Void> deleteProduct(@RequestBody CategoryProduct categoryProduct){
        LOGGER.info("Hizo la peticion de eliminar por id");
        return categoryProductService.eliminar(categoryProduct);

    }

    @PutMapping("/actualizar/{idCategoryProduct}")
    public Mono<CategoryProduct> updateProduct(@RequestBody CategoryProduct categoryProduct, @PathVariable(value = "idCategoryProduct") String idCategoryProduct){

        LOGGER.info("Hizo la peticion de actualizar");
        categoryProduct.setIdCategoryProduct(idCategoryProduct);
        return categoryProductService.save(categoryProduct);

    }
}
