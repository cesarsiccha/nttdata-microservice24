package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Document("Cliente")
@Data
@NoArgsConstructor
public class Client {
    @Id
    private String idClient;
    private CategoryClient idCategoryClient;
    @NotEmpty(message = "el nombre no puede ser vacio")
    private String nombresClient;
    @NotEmpty(message = "el apellido no puede ser vacio")
    private String apellidosClient;
    @Size( min = 8 , max = 8, message = "El dni debe tener 8 digitos")
    private String dniClient;
    private String estado;
}
