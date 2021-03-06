package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document("Producto")
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String idProducto;
    @NotEmpty(message = "el nombre de producto no puede ser vacio")
    private String nombreProducto;
    private String descripcionProducto;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "La categoria no puede ser vacia")
    private CategoryProduct idCategoryProduct;
    private String estado;
}
