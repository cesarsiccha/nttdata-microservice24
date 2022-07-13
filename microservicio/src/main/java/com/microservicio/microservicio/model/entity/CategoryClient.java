package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TipoCliente")
@Data
@NoArgsConstructor
public class CategoryClient {

    @Id
    private String idTipoCliente;
    private String descripcion;
    private String estado;
}
