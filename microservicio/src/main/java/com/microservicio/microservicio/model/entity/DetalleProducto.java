package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("DetalleProductoCliente")
@Data
@NoArgsConstructor
public class DetalleProducto {

    @Id
    private String idDetalleProducto;
    private Cliente idCliente;
    private Producto idProducto;
    private String estado;
}
