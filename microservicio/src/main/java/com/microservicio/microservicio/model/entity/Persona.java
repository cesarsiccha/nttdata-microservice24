package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Persona")
@Data
@NoArgsConstructor
public class Persona {
    @Id
    private String idPersona;
    private String nombresPersona;
    private String apellidosPersona;
    private String dniPersona;
    private int edad;
    private String estado;
}
