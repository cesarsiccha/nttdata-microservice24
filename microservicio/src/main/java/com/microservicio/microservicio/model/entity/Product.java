package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Producto")
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private CategoryProduct idCategoryProduct;
    private String estado;
}
