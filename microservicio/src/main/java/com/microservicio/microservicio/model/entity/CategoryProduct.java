package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TipoProducto")
@Data
@NoArgsConstructor
public class CategoryProduct {

    @Id
    private String idCategoryProduct;
    private String descripcionProducto;
    private String estado;
}
