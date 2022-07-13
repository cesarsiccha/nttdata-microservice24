package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("DetalleProductoCliente")
@Data
@NoArgsConstructor
public class DetailProduct {

    @Id
    private String idDetalleProducto;
    private Client idClient;
    private Product idProduct;
    private String numeroCuenta;
    private String estado;
}
