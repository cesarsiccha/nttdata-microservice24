package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Titular")
@Data
@NoArgsConstructor
public class Titular {
    @Id
    private String idTitular;
    private String nombresTitular;
    private String apellidosTitular;
    private String dniTitular;
    private int edad;
    private String estado;
}
